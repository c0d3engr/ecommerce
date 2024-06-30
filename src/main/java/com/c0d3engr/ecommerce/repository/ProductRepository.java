package com.c0d3engr.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.c0d3engr.ecommerce.model.rest.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
