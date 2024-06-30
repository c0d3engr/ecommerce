package com.c0d3engr.ecommerce.repository;
import org.springframework.stereotype.Repository;
import com.c0d3engr.ecommerce.model.rest.Customer;

@Repository
public class CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
