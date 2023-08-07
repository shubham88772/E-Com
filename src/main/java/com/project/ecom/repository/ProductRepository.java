package com.project.ecom.repository;

import com.project.ecom.model.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
