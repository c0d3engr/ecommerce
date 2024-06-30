package com.c0d3engr.ecommerce.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.c0d3engr.ecommerce.controller.ProductController;
import com.c0d3engr.ecommerce.mapper.ProductMapper;
import com.c0d3engr.ecommerce.model.entity.CategoryEntity;
import com.c0d3engr.ecommerce.model.rest.Category;
import com.c0d3engr.ecommerce.service.CategoryService;
import com.c0d3engr.ecommerce.service.ProductService;

@Component
public class ProductControllerImpl implements ProductController {

    @Autowired
        private ProductService productService;

    @Autowired
        CategoryService CategoryService;
    
    // @Override
    // public Category addCategory(Category category) {
    //     CategoryEntity categoryEntity = ProductMapper.mapCategory(category);
    //     categoryEntity = productService.addCategory(categoryEntity);
    //     return ProductMapper.mapCategoryEntity(categoryEntity);
    // }
    
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value =  "size",defaultValue = "10") Integer size,
                             Map<String,Object> map) {
        PageRequest request = new PageRequest(page - 1,size);
        Page<OrderRepository> OrderRepositoryPage = productService.findAll(request);
        map.put("OrderRepositorypage",OrderRepositoryPage);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                      Map<String,Object> map){
        if(!StringUtils.isEmpty(productId)) {
            ProductRepository ProductRepository = productService.findOne(productId);
            map.put("ProductRepository",ProductRepository);
        }
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }



    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map) {
        if(bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        try{
            ProductRepository ProductRepository = productService.findOne(form.getProductId());
            BeanUtils.copyProperties(form,ProductRepository);
            productService.save(ProductRepository);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}