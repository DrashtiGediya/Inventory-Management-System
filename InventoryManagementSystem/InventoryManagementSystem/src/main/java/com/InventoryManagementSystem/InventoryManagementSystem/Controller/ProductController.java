package com.InventoryManagementSystem.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Product;
import com.InventoryManagementSystem.InventoryManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("saveProducts")
    public void saveProduct(@RequestBody List<Product> products){
        productService.saveProduct(products);
    }
}
