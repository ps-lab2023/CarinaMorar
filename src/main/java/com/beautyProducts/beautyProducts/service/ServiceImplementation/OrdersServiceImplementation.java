package com.beautyProducts.beautyProducts.service.ServiceImplementation;

import com.beautyProducts.beautyProducts.model.BeautyProducts;
import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.model.User;
import com.beautyProducts.beautyProducts.repository.OrdersRepository;
import com.beautyProducts.beautyProducts.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImplementation implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public void OrderServiceImplementation(OrdersRepository orderRepository){
        this.ordersRepository=ordersRepository;
    }
    @Override
    public List<Orders> findAllOrders(){
        return (List<Orders>) ordersRepository.findAll();
    }
    @Override
    public Optional<Orders> findOrderById(Long id){
        return ordersRepository.findById(id);
    }
    @Override
    public Long deleteOrderById(Long id){
        ordersRepository.deleteById(id);
        return id;
    }
    @Override
    public Orders deleteOrder(Orders orders){
        ordersRepository.delete(orders);
        return orders;
    }
    @Override
    public Orders createOrder(Orders orders){
        return ordersRepository.save(orders);
    }
    @Override
    public Orders updateOrderPrice(Orders orders, float price){
        Orders existingOrdersPrice = ordersRepository.findById(orders.getId()).orElse(null);
        existingOrdersPrice.setPrice(price);
        return ordersRepository.save(existingOrdersPrice);
    }
    @Override
    public Orders updateOrderQuantity(Orders orders, int quantity){
        Orders existingOrdersQuantity = ordersRepository.findById(orders.getId()).orElse(null);
        existingOrdersQuantity.setQuantity(quantity);
        return ordersRepository.save(existingOrdersQuantity);
    }

    @Override
    public Orders updateOrderBeautyProductsCart (Orders orders, List<BeautyProducts> beautyProductsCart){
        Orders existingOrders = ordersRepository.findById(orders.getId()).orElse(null);
        existingOrders.setBeautyProductsCart(beautyProductsCart);
        return ordersRepository.save(existingOrders);
    }
    @Override
    public Orders updateUser(Orders orders, User user){
        Orders existingClientOrders = ordersRepository.findById(orders.getId()).orElse(null);
        existingClientOrders.setUser(user);
        return ordersRepository.save(existingClientOrders);
    }
/*    @Override
    public Orders updateOrder(Orders Orders){
        Orders existingOrder = orderRepository.findById(Orders.getId()).orElse(null);
        existingOrder.setPrice(Orders.getPrice());
        existingOrder.setQuantity(Orders.getQuantity());
        existingOrder.setBeautyProductsCart(Orders.getBeautyProductsCart());
        existingOrder.setClientOrders(Orders.getClientOrders());
        return orderRepository.save(existingOrder);
    }*/
}