package com.ecommerce.ecommerce_platform;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ecommerce.controllers.OrderController;
import com.ecommerce.controllers.ProductController;
import com.ecommerce.controllers.UserController;
import com.ecommerce.models.Order;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.utils.DatabaseConnection;

public class Main {

	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Connected to the database successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
        
        UserController userController = new UserController();

        // Test Registration
        
        User newUser1 = new User(0, "john_doe", "password123", "john@example.com", "CUSTOMER");
        User newUser2 = new User(1, "tara_zoe", "password456", "tara@example.com", "ADMIN");
        System.out.println("User 1 : "+newUser1.getUsername());
        System.out.println("User 2 : "+newUser2.getUsername());
        boolean isRegistered = userController.registerUser(newUser1);
        System.out.println("User registration successful: " + isRegistered);
        
        

        // Test Login
        User loggedInUser = userController.loginUser("john_doe", "password123");
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome, " + loggedInUser.getUsername());
        } else {
            System.out.println("Invalid credentials!");
        }
        
        
        ProductController productController = new ProductController();

        // Test Adding Products
        Product product = new Product(0, "Laptop", "High-performance laptop", 1200.50, 10);
        boolean isAdded = productController.addProduct(product);
        System.out.println("Product added successfully: " + isAdded);

        // Test Retrieving Products
        List<Product> products = ProductController.getAllProducts();
        for (Product p : products) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }
        
        
        
        OrderController orderController = new OrderController();

        // Test Placing an Order
        Order order = new Order(0, 1, 1, 2, 2400.00, new Date());
        boolean isPlaced = orderController.placeOrder(order);
        System.out.println("Order placed successfully: " + isPlaced);

        // Test Retrieving Orders
        List<Order> orders = orderController.getAllOrders();
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getId() + ", Total: $" + o.getTotalPrice());
        }
        

        
	}
	
	
	

}
