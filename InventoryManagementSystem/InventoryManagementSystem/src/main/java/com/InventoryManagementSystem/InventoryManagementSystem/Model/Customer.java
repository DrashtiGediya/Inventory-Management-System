package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tbl_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    @Pattern(regexp = "^[1-9][0-9]{9}$",message = "invalid mobile number")
    private String mobileNumber;
    private Address address;


    @ManyToMany
    @JoinTable(name = "product_customer",joinColumns = @JoinColumn(name = "product_id"),
                                      inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Product> products;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "customerBill",cascade = CascadeType.ALL,fetch = FetchType.LAZY
    )
    private List<Bill> bills;

    public Customer(int customerId) {
        this.customerId = customerId;
    }
}
