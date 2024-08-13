package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Product;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(List<Product> products){
        productRepository.saveAll(products);
    }
}
