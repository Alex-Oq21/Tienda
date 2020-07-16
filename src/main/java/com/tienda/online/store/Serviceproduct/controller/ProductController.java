package com.tienda.online.store.Serviceproduct.controller;


import com.tienda.online.store.Serviceproduct.entity.Category;
import com.tienda.online.store.Serviceproduct.entity.Product;
import com.tienda.online.store.Serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name="categoryId", required = false) Long categoryId){
        List<Product> products;
        if (categoryId == null){
            products = productService.ListAllProduct();
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.ok(products);
    }
    @GetMapping(value ="/{id}")
     public ResponseEntity<Product>getProduct(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        if (product == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(product);
        }
     }
     @PostMapping
     public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreate = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
     }
     @PutMapping(value = "/{id}")
     public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        Product productDB = productService.updateProduct(product);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.ok(productDB);
     }
     @DeleteMapping(value="/{id}")
     public  ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        Product productDelete = productService.deleteProduct(id);
        if (productDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDelete);
     }
     @PutMapping(value="/{id}/stock")
     public  ResponseEntity<Product> updateStock(@PathVariable("id") Long id, @RequestParam(name="quantity") Double quantity){
        Product product = productService.updateStock(id, quantity);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.ok(product);
     }
}
