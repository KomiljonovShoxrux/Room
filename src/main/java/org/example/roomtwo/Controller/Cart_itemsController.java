package org.example.roomtwo.Controller;

import org.example.roomtwo.Dto.Cart_itemDto;
import org.example.roomtwo.Service.Cart_itemsService;
import org.example.roomtwo.model.Cart_Items;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartitems")
public class Cart_itemsController {

    @Autowired
    Cart_itemsService cart_itemsService;
    @GetMapping
    public List<Cart_Items> cart_items(){
        return cart_itemsService.getall();
    }
    @GetMapping("/{id}")
    public Cart_Items cart_items(@PathVariable Integer id){
        return cart_itemsService.getcart_items(id);
    }

    @PostMapping
    public Result cart_items(@RequestBody Cart_itemDto cart_itemDto){
        Result result = cart_itemsService.createcart_items(cart_itemDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result cart_items(@PathVariable Integer id, @RequestBody Cart_itemDto cart_itemDto){
        Result result = cart_itemsService.updatecart_items(id, cart_itemDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result delete_cart_items(@PathVariable Integer id){
        Result result = cart_itemsService.deletecart_items(id);
        return result;
    }

}
