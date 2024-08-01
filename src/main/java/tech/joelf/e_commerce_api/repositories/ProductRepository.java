package tech.joelf.e_commerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.joelf.e_commerce_api.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
