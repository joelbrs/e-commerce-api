package tech.joelf.e_commerce_api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<ProductDtoOut> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDtoOut>> findAllPaged(Pageable pageable,
            @RequestParam(required = false) String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllPaged(pageable, name));
    }

    @PostMapping
    public ResponseEntity<ProductDtoOut> create(@RequestBody(required = true) ProductDtoIn dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDtoOut> update(@PathVariable Long id, @RequestBody(required = true) ProductDtoIn dto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
