package com.tienda.online.store.Serviceproduct.service;

import com.tienda.online.store.Serviceproduct.entity.Category;
import com.tienda.online.store.Serviceproduct.entity.Product;

import java.util.List;

public interface ProductService {
        List<Product> ListAllProduct();
        Product getProduct(Long id);
        Product createProduct(Product product);
        Product updateProduct(Product product);
        Product deleteProduct(Long id);
        List<Product> findByCategory(Category category);
        Product updateStock(Long id, Double quantity);
}
