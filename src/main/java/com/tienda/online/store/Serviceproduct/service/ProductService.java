package com.tienda.online.store.Serviceproduct.service;

import com.tienda.online.store.Serviceproduct.entity.Category;
import com.tienda.online.store.Serviceproduct.entity.Product;

import java.util.List;

public interface ProductService {
        public List<Product> ListAllProduct();
        public Product getProduct(Long id);
        public Product createProduct(Product product);
        public Product updateProduct(Product product);
        public Product deleteProduct(Long id);
        public List<Product> findByCategory(Category category);
        public Product updateStock(Long id, Double quantity);
}
