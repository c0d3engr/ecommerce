package com.c0d3engr.ecommerce.repository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findAllByCartId(String cart_id);
}
