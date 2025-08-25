package com.munna.bookcatalog.service;

import com.munna.bookcatalog.entity.Order;
import com.munna.bookcatalog.entity.Book;
import com.munna.bookcatalog.entity.User;
import com.munna.bookcatalog.repository.OrderRepository;
import com.munna.bookcatalog.repository.BookRepository;
import com.munna.bookcatalog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    // Place an order
    public Order placeOrder(Long userId, Long bookId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Book> book = bookRepository.findById(bookId);

        if (user.isEmpty() || book.isEmpty()) {
            throw new RuntimeException("User or Book not found!");
        }

        Order order = new Order();
        order.setUser(user.get());
        order.setBook(book.get());
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get orders by user
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Get orders by book
    public List<Order> getOrdersByBook(Long bookId) {
        return orderRepository.findByBookId(bookId);
    }

    // Cancel order
    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
