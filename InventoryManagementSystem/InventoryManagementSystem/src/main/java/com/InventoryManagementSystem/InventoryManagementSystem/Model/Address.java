package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int houseNo;
    private String city;
    private int pinCode;
    private String area;
}
