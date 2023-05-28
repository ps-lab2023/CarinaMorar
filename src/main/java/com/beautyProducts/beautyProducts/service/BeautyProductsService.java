package com.beautyProducts.beautyProducts.service;

import com.beautyProducts.beautyProducts.DTO.BeautyProductsDTO;
import com.beautyProducts.beautyProducts.model.BeautyProducts;
import com.beautyProducts.beautyProducts.model.Orders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BeautyProductsService{
    List<BeautyProducts> findAllBeautyProducts();

    Optional<BeautyProducts> findBeautyProductsById(Long id);

    List<BeautyProducts> findBeautyProductsByBrand(String brand);

    List<BeautyProducts> findBeautyProductsByCategory(String category);

    List<BeautyProducts> findBeautyProductsByNameProduct(String name);

    Long deleteBeautyProductsById(Long id);

    BeautyProducts deleteBeautyProducts(BeautyProducts beautyProducts);

    BeautyProducts createBeautyProducts(BeautyProducts beautyProducts);

    BeautyProducts updateBeautyProductsName(BeautyProducts beautyProducts, String name);

    BeautyProducts updateBeautyProductsBrand(BeautyProducts beautyProducts, String brand);

    BeautyProducts updateBeautyProductsPrice(BeautyProducts beautyProducts, float price);

    BeautyProducts updateBeautyProductsQuantity(BeautyProducts beautyProducts, int quantity);

    BeautyProducts updateBeautyProductsPriceById(Long id, float price);

    BeautyProducts updateBeautyProductsQuantityById(Long id, int quantity);

    BeautyProducts updateBeautyProductsClientOrder(BeautyProducts beautyProducts, Orders clientOrders);

    List<BeautyProductsDTO> findByIncreasingPrice();

    List<BeautyProductsDTO> findByAscBrand();

    //BeautyProducts updateBeautyProducts(BeautyProducts beautyProducts);
}
