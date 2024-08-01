package tech.joelf.e_commerce_api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import tech.joelf.e_commerce_api.dtos.response.ProductDtoOut;
import tech.joelf.e_commerce_api.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDtoOut getById(Long id) throws Exception {
        var result = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found."));
        return modelMapper.map(result, ProductDtoOut.class);
    }
}
