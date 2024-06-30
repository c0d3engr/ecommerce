package com.c0d3engr.ecommerce.model.rest;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Payment {

    private Integer payment_id;
    private String payment_type;
    private BigDecimal payment_amout;
}
