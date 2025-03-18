package org.example.roomtwo.Repository;

import org.example.roomtwo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);
}
