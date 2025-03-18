package org.example.roomtwo.Repository;

import org.example.roomtwo.model.Cart_Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cart_itemsRepo extends JpaRepository<Cart_Items, Integer> {
    boolean existsBySub_total(String sub_total);
}
