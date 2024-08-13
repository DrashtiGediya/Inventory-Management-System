package com.InventoryManagementSystem.InventoryManagementSystem.Repository;


import com.InventoryManagementSystem.InventoryManagementSystem.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
}
