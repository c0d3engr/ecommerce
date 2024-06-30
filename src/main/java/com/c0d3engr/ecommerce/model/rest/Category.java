package com.c0d3engr.ecommerce.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category {
    
    private Integer category_id;
    private String category_name;
    private String category_picture;
    private String category_description;
}
