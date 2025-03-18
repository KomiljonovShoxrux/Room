package org.example.roomtwo.Repository;

import org.example.roomtwo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Integer> {
}
