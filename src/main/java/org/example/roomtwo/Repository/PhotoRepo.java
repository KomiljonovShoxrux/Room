package org.example.roomtwo.Repository;

import org.example.roomtwo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
}
