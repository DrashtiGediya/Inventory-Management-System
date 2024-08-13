package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Bill;
import com.InventoryManagementSystem.InventoryManagementSystem.Model.Customer;
import com.InventoryManagementSystem.InventoryManagementSystem.Model.Order;
import com.InventoryManagementSystem.InventoryManagementSystem.Model.Product;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.BillRepository;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.CustomerRepository;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.OrderRepository;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SmsService smsService;
    @Autowired
    private WhatsappService whatsappService;
    @Autowired
    private SendCsvInEmail sendCsvInEmail;
    public boolean makePayment(){
        return new Random().nextBoolean();
    }

    public String saveOrder(Order order){
        if(makePayment()) {
            Product product = productRepository.findById(order.getProduct().getProductId()).orElseThrow();
            Customer customer = customerRepository.findById(order.getCustomer().getCustomerId()).orElseThrow();

            customer.getOrders().add(order);
            customer.getProducts().add(product);

            product.setInventoryCount(product.getInventoryCount() - order.getQuantity());

            order.setAddress(customer.getAddress());
            order.setPayableAmount(product.getProductPrice() * order.getQuantity());

            Bill bill = new Bill();
            bill.setQuantity(order.getQuantity());
            bill.setGst(product.getGst());
            bill.setTotalAmount(order.getPayableAmount() + (product.getGst() * order.getQuantity()));
            bill.setCustomerBill(customer);
            bill.setProduct(product);

            orderRepository.save(order);
            productRepository.save(product);
            billRepository.save(bill);

            smsService.sendSms();
            whatsappService.sendMessageToWhatsapp();


            return "order successfully";
        }else {
            return "order failed";
        }
    }
}
