package com.munna.bookcatalog.controller;

import com.munna.bookcatalog.entity.Order;
import com.munna.bookcatalog.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // 1. Fetch all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 2. Fetch order by ID
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    // 3. Create new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // 4. Update an order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setUser(orderDetails.getUser());
            order.setBook(orderDetails.getBook());
            order.setOrderDate(orderDetails.getOrderDate());
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    // 5. Delete order by ID
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "Order deleted successfully!";
    }

    // 6. Fetch orders by User
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // 7. Fetch orders by Book
    @GetMapping("/book/{bookId}")
    public List<Order> getOrdersByBook(@PathVariable Long bookId) {
        return orderRepository.findByBookId(bookId);
    }
}
