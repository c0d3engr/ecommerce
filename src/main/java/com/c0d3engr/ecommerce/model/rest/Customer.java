package com.c0d3engr.ecommerce.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    
    private Integer customer_id;
    private String customer_name;
    private String email;
    private String password;
}
