package com.InventoryManagementSystem.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Order;
import com.InventoryManagementSystem.InventoryManagementSystem.Service.CustomerService;
import com.InventoryManagementSystem.InventoryManagementSystem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @PostMapping("saveOrder")
    public String  saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/getOrders")
    public void getOrders(@RequestParam int id){
        customerService.checkOrdersOfCustomer(id);
    }
}

