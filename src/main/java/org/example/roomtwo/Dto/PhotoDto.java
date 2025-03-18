package org.example.roomtwo.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String size;
}
