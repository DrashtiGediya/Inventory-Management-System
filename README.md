# Inventory-Management-System
The Inventory Management System, built with Spring Boot, manages customer orders, inventory, and admin tasks. It integrates MySQL for data storage and automates notifications via SMS, WhatsApp, and email. Ensures seamless customer interaction, efficient order processing, and real-time inventory management with threshold alerts.

# Overview
TheInventory-Management-System is a Spring Boot-based application designed to manage customer orders, product inventory, and administrative tasks. It integrates with MySQL for data storage and provides automated notifications through SMS, WhatsApp, and email. This system ensures seamless customer interaction, efficient order processing, and real-time inventory management with threshold alerts.

# Features
Customer Management: Capture customer details including name and mobile number during the order process.

Product Management: Manage product inventory, including updating stock levels after each purchase.

Order Processing: Customers can purchase products, and the system generates a detailed bill, including GST calculation.

Payment Confirmation: The system verifies payment and sends a confirmation notification to the customer via SMS and WhatsApp.

Inventory Alerts: If a product’s stock falls below 100 units, the system sends an automated email alert to the admin, including a CSV file detailing the products that have reached the threshold.

Report Generation: Generate detailed reports on sales, inventory status, and campaign effectiveness.

Admin Notifications: Automated alerts and CSV reports are sent to the admin for low-stock items, helping in proactive inventory management.

# Technology Stack
Backend: Spring Boot, Java

Database: MySQL

Notifications: Twilio API for SMS and WhatsApp messages

Email: JavaMail API for sending emails to the admin

File Handling: Apache Commons CSV for generating CSV files

Build Tool: Maven

# Update application properties:
Configure your MySQL database settings in application.properties.

Add your Twilio credentials and email server configurations.

# API Endpoints
Customer Management:

POST /customer/saveCustomer - Add a new customer.

Product Management:

POST /product/saveProducts - Add products.

Order Management:

POST /order/saveOrder - Create a new order.

GET /order/getOrders?id=1 - Retrieve order details.

# Admin Alerts:
Automated email alerts when product inventory falls below threshold.
