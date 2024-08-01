package tech.joelf.e_commerce_api.controllers;

import org.springframework.web.bind.annotation.*;

import tech.joelf.e_commerce_api.dtos.response.ProductDtoOut;
import tech.joelf.e_commerce_api.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ProductDtoOut getById(@PathVariable Long id) throws Exception {
        return productService.getById(id);
    }
}
