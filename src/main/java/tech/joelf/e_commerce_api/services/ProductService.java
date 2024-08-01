package tech.joelf.e_commerce_api.services;

import org.springframework.stereotype.Service;

import tech.joelf.e_commerce_api.dtos.response.ProductDtoOut;
import tech.joelf.e_commerce_api.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDtoOut getById(Long id) throws Exception {
        var result = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found."));
        return new ProductDtoOut(result.getId(), result.getName(), result.getDescription(), result.getPrice(),
                result.getImgUrl());
    }
}
