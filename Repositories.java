package com.proj.inventory.repository;


import com.proj.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}


// UserRepository
package com.example.inventory.repository;


import com.example.inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String username);
}


// OrderRepository
package com.example.inventory.repository;


import com.example.inventory.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
