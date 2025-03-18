package org.example.roomtwo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.roomtwo.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String size;
    @ManyToOne
    private Photo photo_id;
    @Column(unique = true)
    private String price;
    @CreatedDate
    private LocalDateTime created_date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany
    private List<Like> like_id;
    @Column(nullable = false)
    private String cart_items;
}
