package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Customer;
import com.InventoryManagementSystem.InventoryManagementSystem.Model.Order;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomers(List<Customer> customers){
        customerRepository.saveAll(customers);
    }

    public void checkOrdersOfCustomer(int id){
        Customer customer = customerRepository.findById(id).get();
        List<Order> orders = customer.getOrders();
        for (Order order : orders) {
            System.out.println(order.getOrder_id());
        }
    }
}
