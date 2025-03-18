package org.example.roomtwo.Controller;

import org.example.roomtwo.Dto.CardDto;
import org.example.roomtwo.Service.CardService;
import org.example.roomtwo.model.Card;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @GetMapping
    public List<Card> cards(){
        return cardService.getall();
    }

    @GetMapping("/{id}")
    public Card card(@PathVariable Integer id){
        return cardService.getCardById(id);
    }

    @PostMapping
    public Result createCard(@RequestBody CardDto cardDto){
        Result result = cardService.createCard(cardDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateCard(@PathVariable Integer id, @RequestBody CardDto cardDto){
        Result result = cardService.updateCard(id, cardDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteCard(@PathVariable Integer id){
        Result result = cardService.deleteCard(id);
        return result;
    }
}
