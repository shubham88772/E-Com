package com.project.ecom.service.impl;

import com.project.ecom.Exception.ResourceNotFoundException;
import com.project.ecom.model.Product;
import com.project.ecom.repository.ProductRepository;
import com.project.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        Product addedPro=productRepository.save(product);
        return addedPro;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> allProduct=productRepository.findAll();
        return allProduct;
    }

    @Override
    public Product getById(int product_id) {
        Product byId=productRepository.findById(product_id).orElseThrow(()->new ResourceNotFoundException("Product Not Found"+product_id));
        return byId;
    }

    @Override
    public void deleteById(int product_id) {
        Product toBeDeleted=productRepository.findById(product_id).orElseThrow(()->new ResourceNotFoundException("Product Not Found to be deleted"));
        productRepository.deleteById(product_id);
    }

    @Override
    public Product updateById(int product_id, Product newproduct) {
        Product oldProduct= productRepository.findById(product_id).orElseThrow(()->new ResourceNotFoundException("Product Not Found"+product_id));
        oldProduct.setProduct_name(newproduct.getProduct_name());
        oldProduct.setProduct_desc(newproduct.getProduct_desc());
        oldProduct.setProduct_quantity(newproduct.getProduct_quantity());
        oldProduct.setProduct_imageName(newproduct.getProduct_imageName());
        oldProduct.setProduct_price(newproduct.getProduct_price());
        oldProduct.setStock(newproduct.isLive());
        oldProduct.setLive(newproduct.isLive());
        Product savedProduct=productRepository.save(oldProduct);

        return savedProduct;
    }


}
