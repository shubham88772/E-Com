package com.project.ecom.controller;

import com.project.ecom.model.Product;
import com.project.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Add New Product
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
         Product addedProduct=productService.addProduct(product);
         return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
    }
    //Get All Product
    @GetMapping("/getall")
    public List<Product> getAllProduct(){
        List<Product> allProduct=productService.getAllProduct();
        return  allProduct;
    }
    // Get Product By Product Id
    @GetMapping("/getbyid/{product_id}")
    public Product getById(@PathVariable int product_id  ){
        Product resById=productService.getById(product_id);
        return resById;
    }

    //Update Product
    @PutMapping("/{product_id}")
    public Product updateById(@PathVariable int product_id ,@RequestBody Product newproduct){
        Product updated=productService.updateById(product_id,newproduct);
        return updated;
    }


    //Delete Product By Product Id
    @DeleteMapping("/delete/{product_id}")
    public void deleteProductById(@PathVariable int product_id){
        productService.deleteById(product_id);
        System.out.println("Product Deleted");

    }





}
