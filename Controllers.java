package com.proj.inventory.controller;


import com.proj.inventory.entity.Product;
import com.proj.inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
private final ProductService service;
public ProductController(ProductService service) { this.service = service; }


@GetMapping
public List<Product> list() { return service.findAll(); }


@GetMapping("/{id}")
public ResponseEntity<Product> get(@PathVariable Long id) {
Product p = service.findById(id);
return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
}


@PostMapping
public Product create(@RequestBody Product p) { return service.save(p); }


@PutMapping("/{id}")
public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) {
Product existing = service.findById(id);
if (existing == null) return ResponseEntity.notFound().build();
p.setId(id);
return ResponseEntity.ok(service.save(p));
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
service.delete(id);
return ResponseEntity.noContent().build();
}
}






package com.proj.inventory.controller;


import com.proj.inventory.entity.Order;
import com.proj.inventory.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
private final OrderService service;
public OrderController(OrderService service) { this.service = service; }


@PostMapping
public Order create(@RequestBody Order order) { return service.createOrder(order); }


@GetMapping
public List<Order> list() { return service.repo.findAll(); }
}
