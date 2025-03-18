package org.example.roomtwo.Service;

import org.example.roomtwo.Dto.CardDto;
import org.example.roomtwo.Repository.CardRepo;
import org.example.roomtwo.model.Card;
import org.example.roomtwo.model.Result;
import org.example.roomtwo.model.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepo cardRepo;

    public List<Card> getall(){
        return cardRepo.findAll();
    }
    public Card getCardById(Integer id){
        return cardRepo.findById(id).get();
    }

    public Result createCard(CardDto cardDto){
        Card card = new Card();
        card.setCard_Number(cardDto.getCard_Number());
        card.setStatus(Status.ACTIVE);
        cardRepo.save(card);
        return new Result(true, "Card created");
    }
    public Result updateCard(Integer id , CardDto cardDto){
        Optional<Card> cardOptional= cardRepo.findById(id);
        if(cardOptional.isPresent()){
            Card card = cardOptional.get();
            card.setCard_Number(cardDto.getCard_Number());
            card.setStatus(Status.ACTIVE);
            cardRepo.save(card);
            return new Result(true, "Card updated");
        }
        return new Result(false, "Card not found");
    }
    public Result deleteCard(Integer id){
        cardRepo.deleteById(id);
        return new Result(true, "Card deleted");
    }
}
