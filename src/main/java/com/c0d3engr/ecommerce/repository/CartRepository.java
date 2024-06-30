package com.c0d3engr.ecommerce.repository;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository extends JpaRepository<Cart, Integer> {
    
}
