package com.project.ecom.controller;

import com.project.ecom.model.Product;
import com.project.ecom.payload.ProductDto;
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
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto product){
         Product addedProduct=productService.addProduct(product);
         return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
    }
    //Get All Product
    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProduct=productService.getAllProduct();
        return  new ResponseEntity<List<Product>>(allProduct,HttpStatus.ACCEPTED);
    }
    // Get Product By Product Id
    @GetMapping("/getbyid/{product_id}")
    public ResponseEntity<Product> getById(@PathVariable int product_id  ){
        Product resById=productService.getById(product_id);
        return new ResponseEntity<Product>(resById,HttpStatus.ACCEPTED);
    }

    //Update Product
    @PutMapping("/{product_id}")
    public ResponseEntity<Product> updateById(@PathVariable int product_id ,@RequestBody Product newproduct){
        Product updated=productService.updateById(product_id,newproduct);
        return new ResponseEntity<Product>(updated,HttpStatus.OK);
    }


    //Delete Product By Product Id
    @DeleteMapping("/delete/{product_id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int product_id){
        productService.deleteById(product_id);
        return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
    }


}
