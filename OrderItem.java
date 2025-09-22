package com.proj.inventory.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private Product product;


private Integer quantity;


private Double unitPrice;
}


// backend/src/main/java/com/example/inventory/entity/Order.java
package com.example.inventory.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private LocalDateTime createdAt;


@OneToMany(cascade = CascadeType.ALL)
private List<OrderItem> items;


private Double total;
}
