package com.c0d3engr.ecommerce.repository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
