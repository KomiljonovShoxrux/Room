package org.example.roomtwo.Dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.roomtwo.model.Card;
import org.example.roomtwo.model.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart_itemDto {

    @OneToMany
    private Integer product_id;

    private String sub_total;
    @ManyToOne
    private Integer card_id;
}
