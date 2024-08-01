package tech.joelf.e_commerce_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.joelf.e_commerce_api.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p " +
            "where (:name is null or p.name like %:name%) " +
            "order by p.name ")
    public Page<Product> findAllPagedByName(Pageable pageable, String name);
}
