package com.tienda.online.store.Serviceproduct.controller;


import com.tienda.online.store.Serviceproduct.entity.Product;
import com.tienda.online.store.Serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> products = productService.ListAllProduct();
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}
