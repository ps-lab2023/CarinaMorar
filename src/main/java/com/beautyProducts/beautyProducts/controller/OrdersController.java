package com.beautyProducts.beautyProducts.controller;

import com.beautyProducts.beautyProducts.DTO.OrdersDTO;
import com.beautyProducts.beautyProducts.DTO.UserDTO;
import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public List<OrdersDTO> findAllOrders(){
        List<Orders> orders1 = ordersService.findAllOrders();
        List<OrdersDTO> ordersDTO = orders1.stream().map(orders ->
                modelMapper.map(orders,OrdersDTO.class)).collect(Collectors.toList());
        return ordersDTO;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findOrdersById(@PathVariable Long id){
        Optional<Orders> orders = ordersService.findOrderById(id);
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(ordersDTO);
    }

    @DeleteMapping("/delete")
    public OrdersDTO deleteOrders(@RequestBody Orders orders){
        Orders orders1 = ordersService.deleteOrder(orders);
        OrdersDTO ordersDTO = modelMapper.map(orders1, OrdersDTO.class);

        return ordersDTO;
    }

    @DeleteMapping("/deleteById/{id}")
    public OrdersDTO deleteOrdersById(@PathVariable Long id){
        Optional<Orders> orders1 = ordersService.findOrderById(ordersService.deleteOrderById(id));
        OrdersDTO ordersDTO = modelMapper.map(orders1, OrdersDTO.class);

        return ordersDTO;
    }

    @PutMapping("/updatePrice/{price}")
    public OrdersDTO updateOrdersPrice(@RequestBody Orders orders, @PathVariable Float price){
        Orders orders1 = ordersService.updateOrderPrice(orders, price);
        OrdersDTO ordersDTO = modelMapper.map(orders1, OrdersDTO.class);
        return ordersDTO;
    }

    @PutMapping("/updateQuantity/{quantity}")
    public OrdersDTO updateOrdersQuantity(@RequestBody Orders orders, @PathVariable int quantity){
        Orders orders1 = ordersService.updateOrderQuantity(orders, quantity);
        OrdersDTO ordersDTO = modelMapper.map(orders1, OrdersDTO.class);
        return ordersDTO;
    }

    @PutMapping("/create")
    public OrdersDTO createOrders(@RequestBody Orders orders) {
        Orders orders1= ordersService.createOrder(orders);
        OrdersDTO ordersDTO = modelMapper.map(orders1, OrdersDTO.class);
        return ordersDTO;
    }
}
