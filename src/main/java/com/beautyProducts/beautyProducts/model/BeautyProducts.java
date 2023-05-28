package com.beautyProducts.beautyProducts.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class BeautyProducts  implements Comparable<BeautyProducts>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameProduct;
    private String brand;
    private int quantity;
    private float price;
    private String img;
    private String category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Orders clientOrders;

    @Override
    public int compareTo(BeautyProducts o) {
        if(this.getPrice()<o.getPrice()) return -1;
        else if (this.getPrice()>o.getPrice()) return 9;
        else return 0;
    }
}
