package org.example.roomtwo.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.roomtwo.model.entity.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {

    @Column(nullable = false)
    private String name;
    private Status status;
    private Integer count;
}
