package com.c0d3engr.ecommerce.mapper;

import com.c0d3engr.ecommerce.model.entity.ProductEntity;
import com.c0d3engr.ecommerce.model.rest.Product;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper { 
    public static final ProductEntity mapProduct (Product product) {
        return ProductEntity.builder().id(product.getId()).name(product.getName()).build();
    }
    
    public static final Product mapProductEntity (ProductEntity productEntity) {
        return Product.builder().id(productEntity.getId()).name(productEntity.getName()).build();
    }
}
