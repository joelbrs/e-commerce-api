package tech.joelf.e_commerce_api.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tech.joelf.e_commerce_api.dtos.request.ProductDtoIn;
import tech.joelf.e_commerce_api.dtos.response.ProductDtoOut;
import tech.joelf.e_commerce_api.exceptions.ResourceNotFoundException;
import tech.joelf.e_commerce_api.models.Product;
import tech.joelf.e_commerce_api.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDtoOut getById(Long id) {
        var result = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found."));
        return modelMapper.map(result, ProductDtoOut.class);
    }

    public Page<ProductDtoOut> findAllPaged(Pageable pageable, String name) {
        var result = productRepository.findAllPagedByName(pageable, name);
        return result.map(p -> modelMapper.map(p, ProductDtoOut.class));
    }

    public ProductDtoOut create(ProductDtoIn dto) {
        var result = productRepository.save(modelMapper.map(dto, Product.class));
        return modelMapper.map(result, ProductDtoOut.class);
    }

    public ProductDtoOut update(Long id, ProductDtoIn dto) {
        var product = productRepository.getReferenceById(id);
        BeanUtils.copyProperties(modelMapper.map(dto, Product.class), product, "id");

        return modelMapper.map(productRepository.save(product), ProductDtoOut.class);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
