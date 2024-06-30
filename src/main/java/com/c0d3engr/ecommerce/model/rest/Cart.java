package com.c0d3engr.ecommerce.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cart {
    
    private Integer cart_id;
    private Integer customer_id; // This is a foreign key from table tbl_customer.
}
