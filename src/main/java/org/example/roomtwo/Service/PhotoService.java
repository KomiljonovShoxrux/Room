package org.example.roomtwo.Service;

import org.example.roomtwo.Dto.PhotoDto;
import org.example.roomtwo.Repository.PhotoRepo;
import org.example.roomtwo.model.Photo;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    PhotoRepo photoRepo;

    public List<Photo> getAll() {
        return photoRepo.findAll();
    }

    public Photo getById(Integer id) {
        return photoRepo.findById(id).get();
    }

    public Result createPhoto(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setName(photoDto.getName());
        photo.setSize(photoDto.getSize());
        photoRepo.save(photo);
        return new Result(true, "Photo Created");
    }

    public Result updatePhoto( Integer id, PhotoDto photoDto) {
        Optional<Photo> photoOptional = photoRepo.findById(id);
        if (photoOptional.isPresent()) {
            Photo photo = photoOptional.get();
            photo.setName(photoDto.getName());
            photo.setSize(photoDto.getSize());
            photoRepo.save(photo);
            return new Result(true, "Photo Updated");
        }
        return new Result(false, "Photo Not Found");
    }

    public Result deletePhoto(Integer id) {
        photoRepo.deleteById(id);
        return new Result(true, "Photo Deleted");
    }
}
