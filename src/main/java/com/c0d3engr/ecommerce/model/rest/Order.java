package com.c0d3engr.ecommerce.model.rest;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    
    private Integer order_id;
    private BigDecimal order_amount;
    private Date order_date;
}
