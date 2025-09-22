package com.proj.inventory.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


private String sku;


private String description;


private Integer quantity;


private Double price;
}
