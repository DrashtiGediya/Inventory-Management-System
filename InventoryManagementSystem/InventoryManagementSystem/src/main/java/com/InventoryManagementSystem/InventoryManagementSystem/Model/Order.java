package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    private int quantity;
    private double payableAmount;
    private Address address;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

}
