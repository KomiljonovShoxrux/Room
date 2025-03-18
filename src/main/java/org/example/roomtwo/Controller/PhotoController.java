package org.example.roomtwo.Controller;

import org.example.roomtwo.Dto.PhotoDto;
import org.example.roomtwo.Service.PhotoService;
import org.example.roomtwo.model.Photo;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;
    @GetMapping
    public List<Photo> getPhotoService() {
        return photoService.getAll();
    }
    @GetMapping("/{id}")
    public Photo addPhoto(@PathVariable Integer id) {
       return photoService.getById(id);
    }
  @PostMapping
    public Result addPhoto(@RequestBody PhotoDto photoDto) {
        Result result = photoService.createPhoto(photoDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updatePhoto(@PathVariable Integer id, @RequestBody PhotoDto photoDto) {
        Result result = photoService.updatePhoto(id, photoDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deletePhoto(@PathVariable Integer id) {
        Result result = photoService.deletePhoto(id);
        return result;
    }
}
