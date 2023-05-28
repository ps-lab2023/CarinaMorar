package com.beautyProducts.beautyProducts;

import com.beautyProducts.beautyProducts.model.BeautyProducts;

import java.util.Comparator;

public class BeautyProductsComparator implements Comparator<BeautyProducts> {
    @Override
    public int compare(BeautyProducts a, BeautyProducts b) {
        return a.getBrand().compareTo(b.getBrand());
    }
}