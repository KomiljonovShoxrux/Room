package org.example.roomtwo.Dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.roomtwo.model.Like;
import org.example.roomtwo.model.entity.Status;
import org.example.roomtwo.model.Photo;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String size;
    @ManyToOne
    private Integer photo_id;
    @Column(unique = true)
    private String price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany
    private Integer like_id;
    @Column(nullable = false)
    private String cart_items;
}
