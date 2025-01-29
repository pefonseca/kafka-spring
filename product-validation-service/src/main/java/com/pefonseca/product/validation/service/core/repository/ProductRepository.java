package com.pefonseca.product.validation.service.core.repository;

import com.pefonseca.product.validation.service.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByCode(String code);
}
