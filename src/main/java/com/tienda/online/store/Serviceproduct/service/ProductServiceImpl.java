package com.tienda.online.store.Serviceproduct.service;

import com.tienda.online.store.Serviceproduct.entity.Category;
import com.tienda.online.store.Serviceproduct.entity.Product;
import com.tienda.online.store.Serviceproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> ListAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("Creado");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productBD = getProduct(product.getId());
        if (productBD == null){
            return null;
        }
        productBD.setName(product.getName());
        productBD.setDescription(product.getDescription());
        productBD.setCategory(product.getCategory());
        productBD.setPrice(product.getPrice());
        return productRepository.save(productBD);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productBD = getProduct(id);
        if (productBD == null){
            return null;
        }
        productBD.setStatus("Eliminado");
        return productRepository.save(productBD);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productBD = getProduct(id);
        if (productBD == null){
            return null;
        }
        Double stock = productBD.getStock() + quantity;
        productBD.setStock(stock);
        return productRepository.save(productBD);
    }
}
