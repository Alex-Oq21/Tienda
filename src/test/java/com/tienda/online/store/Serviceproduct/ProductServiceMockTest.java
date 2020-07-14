package com.tienda.online.store.Serviceproduct;

import com.tienda.online.store.Serviceproduct.entity.Category;
import com.tienda.online.store.Serviceproduct.entity.Product;
import com.tienda.online.store.Serviceproduct.repository.ProductRepository;
import com.tienda.online.store.Serviceproduct.service.ProductService;
import com.tienda.online.store.Serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;
    private ProductService productService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("Computador")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("125.000"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }
    @Test
     public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
         Assertions.assertThat(found.getName()).isEqualTo("Computador");
     }
     @Test
     public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
     }
}
