package com.InventoryManagementSystem.InventoryManagementSystem.Repository;


import com.InventoryManagementSystem.InventoryManagementSystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
