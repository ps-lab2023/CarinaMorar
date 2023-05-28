package com.beautyProducts.beautyProducts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private Long id;
    private float price;
    private int quantity;
}
