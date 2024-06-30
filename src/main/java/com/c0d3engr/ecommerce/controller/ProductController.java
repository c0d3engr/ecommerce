package com.c0d3engr.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.c0d3engr.ecommerce.model.rest.Category;

@RestController
@RequestMapping ("/product")
public interface ProductController {
    @PostMapping ("/category")
    @ResponseStatus (code = HttpStatus.CREATED)
    Category addCategory (@RequestBody Category category);
}
