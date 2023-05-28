package com.beautyProducts.beautyProducts.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeautyProductsDTO {
    private Long id;
    private String nameProduct;
    private String brand;
    private int quantity;
    private float price;
    private String img;
    private String category;
}

