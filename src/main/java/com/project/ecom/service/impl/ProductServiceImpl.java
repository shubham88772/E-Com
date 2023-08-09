package com.project.ecom.service.impl;

import com.project.ecom.Exception.ResourceNotFoundException;
import com.project.ecom.model.Product;
import com.project.ecom.payload.ProductDto;
import com.project.ecom.repository.ProductRepository;
import com.project.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDto addProduct(ProductDto product){
        //Product DTO to Product
        Product entity=toEntity(product);
        Product addedPro=productRepository.save(entity);
        ProductDto converted=toDto(addedPro);
        return converted;
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
    public Product toEntity(ProductDto productDto){
        Product p=new Product();
        p.setProduct_name(productDto.getProduct_name());
        p.setProduct_price(productDto.getProduct_price());
        p.setProduct_desc(productDto.getProduct_desc());
        p.setProduct_quantity(productDto.getProduct_quantity());
        p.setStock(productDto.isStock());
        p.setLive(productDto.isLive());
        p.setProduct_id(productDto.getProduct_id());
        p.setProduct_imageName(productDto.getProduct_imageName());
        return p;
    }
    public ProductDto toDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setProduct_desc(productDto.getProduct_desc());
        productDto.setProduct_name(productDto.getProduct_name());
        productDto.setProduct_imageName(product.getProduct_imageName());
        productDto.setProduct_price(productDto.getProduct_price());
        productDto.setLive(productDto.isLive());
        productDto.setStock(product.isStock());
        return productDto;

    }


}
