package com.InventoryManagementSystem.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM tbl_product WHERE inventory_count < 50",nativeQuery = true)
    List<Product> getProducts();
}
