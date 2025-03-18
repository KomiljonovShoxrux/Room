package org.example.roomtwo.Controller;

import org.example.roomtwo.Dto.LikeDto;
import org.example.roomtwo.Service.LikeService;
import org.example.roomtwo.model.Like;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    LikeService likeService;
    @GetMapping
    public List<Like> getLikes(){
        return likeService.likeList();
    }
    @GetMapping("/{id}")
    public Like getLike(@PathVariable Integer id){
        return likeService.getbyidLike(id);
    }

    @PostMapping
    public Result addLike(@RequestBody LikeDto likeDto){
        Result result = likeService.createLike(likeDto);
        return result;
    }

    @PutMapping
    public Result updateLike(@RequestBody Integer id,  LikeDto likeDto){
        Result result = likeService.updateLike(id, likeDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteLike(@PathVariable Integer id){
        Result result = likeService.deleteLike(id);
        return result;
    }

}
