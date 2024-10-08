package com.educastro.sales.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jesus Castro
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    private String name;
    private float price;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
