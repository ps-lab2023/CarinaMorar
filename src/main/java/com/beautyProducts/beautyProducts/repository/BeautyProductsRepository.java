package com.beautyProducts.beautyProducts.repository;

import com.beautyProducts.beautyProducts.DTO.BeautyProductsDTO;
import com.beautyProducts.beautyProducts.model.BeautyProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeautyProductsRepository extends CrudRepository<BeautyProducts,Long> {
    BeautyProducts findFirstBeautyProductsById(Long id);

    BeautyProductsDTO findBeautyProductsById(Long id);

    List<BeautyProducts> findBeautyProductsByBrand(String brand);
    List<BeautyProducts> findBeautyProductsByCategory(String category);

    List<BeautyProducts> findBeautyProductsByNameProduct(String name);
}
