package com.InventoryManagementSystem.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
