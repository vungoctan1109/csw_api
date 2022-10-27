package com.fpt.csw_final_api.service;

import com.fpt.csw_final_api.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public void addProduct(Product product);

    public Product findById(Integer id);
    public void saveProduct(Product product);
}
