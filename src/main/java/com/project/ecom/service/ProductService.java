package com.project.ecom.service;

import com.project.ecom.model.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    List<Product> getAllProduct();

    Product getById(int product_id);

    public void deleteById(int product_id);

    Product updateById(int product_id, Product newproduct);
}
