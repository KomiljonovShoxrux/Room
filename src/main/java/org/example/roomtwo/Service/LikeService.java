package org.example.roomtwo.Service;

import org.example.roomtwo.Dto.LikeDto;
import org.example.roomtwo.Repository.LikeRepo;
import org.example.roomtwo.model.Like;
import org.example.roomtwo.model.Result;
import org.example.roomtwo.model.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    LikeRepo likeRepo;

    public List<Like> likeList(){
        return likeRepo.findAll();
    }
    public Like getbyidLike(Integer id){
        return likeRepo.findById(id).get();
    }

    public Result createLike(LikeDto likeDto){
        Like like = new Like();
        like.setName(likeDto.getName());
        like.setStatus(Status.ACTIVE);
        like.setCount(likeDto.getCount());
        likeRepo.save(like);

        return new Result(true, "Like created");
    }
    public Result updateLike( Integer id , LikeDto likeDto){
        Optional<Like> like = likeRepo.findById(id);
        if(like.isPresent()){
            Like like1 = like.get();
            like1.setName(likeDto.getName());
            like1.setCount(likeDto.getCount());
            like1.setStatus(Status.ACTIVE);
            likeRepo.save(like1);
            return new Result(true, "Like updated");
        }
        return new Result(false, "Like not found");
    }
    public Result deleteLike(Integer id){
        likeRepo.deleteById(id);
        return new Result(true, "Like deleted");
    }
}
