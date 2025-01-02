package com.ecommerce.ecommerce_platform;

import com.ecommerce.models.Cart;
import com.ecommerce.models.CartItem;
import com.ecommerce.models.Product;

public class CartActions {
    public static void main(String[] args) {
        // Create sample products
        Product product1 = new Product(1, "Laptop", "High performance laptop", 1200.00, 10);
        Product product2 = new Product(2, "Smartphone", "Latest model smartphone", 800.00, 15);

        // Create a cart and add items
        Cart cart = new Cart();
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);

        // Print out the cart items and total price
        System.out.println("Cart Contents:");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity() + " = " + item.getTotalPrice());
        }
        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}
