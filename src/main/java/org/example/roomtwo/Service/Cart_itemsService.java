package org.example.roomtwo.Service;

import org.example.roomtwo.Dto.Cart_itemDto;
import org.example.roomtwo.Repository.CardRepo;
import org.example.roomtwo.Repository.Cart_itemsRepo;
import org.example.roomtwo.Repository.ProductRepo;
import org.example.roomtwo.model.Card;
import org.example.roomtwo.model.Cart_Items;
import org.example.roomtwo.model.Product;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Cart_itemsService {
    @Autowired
    Cart_itemsRepo cart_itemsRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CardRepo cardRepo;

    public List<Cart_Items> getall(){
        return cart_itemsRepo.findAll();
    }

    public Cart_Items getcart_items(Integer id){
        return cart_itemsRepo.getById(id);
    }

    public Result createcart_items(Cart_itemDto cart_itemDto){
        boolean existsbysubtotal =cart_itemsRepo.existsBySub_total(cart_itemDto.getSub_total());
        if(existsbysubtotal){
            return new Result(false, "Subtotal already exists");
        }
        Cart_Items cart_items = new Cart_Items();
        cart_items.setSub_total(cart_itemDto.getSub_total());

        Optional<Product> productOptional=productRepo.findById(cart_itemDto.getProduct_id());
        Product product = productOptional.get();


        Optional<Card> cardOptional=cardRepo.findById(cart_itemDto.getCard_id());
        Card card = cardOptional.get();

        cart_items.setProduct_id((List<Product>) product);
        cart_items.setCard_id(card);
        cart_itemsRepo.save(cart_items);
        return new Result(true, "Successfully created");
    }

    public Result updatecart_items( Integer id,Cart_itemDto cart_itemDto){
        Optional<Cart_Items> cartItemsOptional=cart_itemsRepo.findById(id);
        if (cartItemsOptional.isPresent()) {
            Cart_Items cart_items=cartItemsOptional.get();
            cart_items.setSub_total(cart_itemDto.getSub_total());
            Optional<Product> productOptional=productRepo.findById(cart_itemDto.getProduct_id());
            Product product = productOptional.get();

            Optional<Card> cardOptional=cardRepo.findById(cart_itemDto.getCard_id());
            Card card = cardOptional.get();

            cart_items.setProduct_id((List<Product>) product);
            cart_items.setCard_id(card);
            cart_itemsRepo.save(cart_items);
            return new Result(true, "Successfully updated");
        }
        return new Result(false, "Not found");
    }


    public Result deletecart_items(Integer id){
        cart_itemsRepo.deleteById(id);
        return new Result(true, "Successfully deleted");
    }
}
