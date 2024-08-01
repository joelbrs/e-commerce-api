package tech.joelf.e_commerce_api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import tech.joelf.e_commerce_api.dtos.request.ProductDtoIn;
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

    @GetMapping
    public Page<ProductDtoOut> findAllPaged(Pageable pageable, @RequestParam(required = false) String name) {
        return productService.findAllPaged(pageable, name);
    }

    @PostMapping
    public ProductDtoOut create(@RequestBody(required = true) ProductDtoIn dto) {
        return productService.create(dto);
    }
}
