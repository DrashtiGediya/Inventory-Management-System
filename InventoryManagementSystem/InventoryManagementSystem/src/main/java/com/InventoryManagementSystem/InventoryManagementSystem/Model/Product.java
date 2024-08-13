package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double productPrice;
    private double gst;
    private int inventoryCount;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Bill> bills;

    public Product(int productId) {
        this.productId = productId;
    }
}
