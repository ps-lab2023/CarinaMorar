package com.beautyProducts.beautyProducts.repository;

import com.beautyProducts.beautyProducts.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
}

