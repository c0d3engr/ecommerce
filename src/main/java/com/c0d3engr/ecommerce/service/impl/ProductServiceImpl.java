package com.c0d3engr.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c0d3engr.ecommerce.model.entity.ProductEntity;
import com.c0d3engr.ecommerce.repository.ProductRepository;
import com.c0d3engr.ecommerce.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductRepository findOne(String product_id) {
        return repository.findOne(product_id);
    }

    @Override
    public List<ProductRepository> findUpAll() {
        return repository.findByProductStatus(0);
    }

    @Override
    public Page<ProductRepository> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductRepository save(ProductRepository ProductRepository) {
        return repository.save(ProductRepository);
    }

    @Override
    public void increaseStock(List<CartRepository> CartRepositoryList) {
        for(CartRepository CartRepository : CartRepositoryList) {
            ProductRepository ProductRepository = repository.findOne(CartRepository.getproduct_id());
            if(ProductRepository == null){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            Integer result = ProductRepository.getProductStock() - CartRepository.getProductQuantity();

            if(result < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);

            ProductRepository.setProductStock(result);
            repository.save(ProductRepository);
        }
    }

    @Override
    public void decreaseStock(List<CartRepository> CartRepositoryList) {
        for(CartRepository CartRepository : CartRepositoryList) {
            ProductRepository ProductRepository = repository.findOne(CartRepository.getproduct_id());
            if(ProductRepository == null){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            Integer result = ProductRepository.getProductStock() + CartRepository.getProductQuantity();

            ProductRepository.setProductStock(result);
            repository.save(ProductRepository);
        }

    }
    
}
