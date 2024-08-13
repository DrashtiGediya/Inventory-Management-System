package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_bill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    private int quantity;
    private double gst;
    private double totalAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customerBill;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

//    public Bill(int billId) {
//        this.billId = billId;
//    }
}
