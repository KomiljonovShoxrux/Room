package org.example.roomtwo.Repository;

import org.example.roomtwo.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Integer> {
}
