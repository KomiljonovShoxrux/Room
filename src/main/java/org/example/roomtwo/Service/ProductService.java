package org.example.roomtwo.Service;

import org.example.roomtwo.Dto.ProductDto;
import org.example.roomtwo.Repository.Cart_itemsRepo;
import org.example.roomtwo.Repository.LikeRepo;
import org.example.roomtwo.Repository.PhotoRepo;
import org.example.roomtwo.Repository.ProductRepo;
import org.example.roomtwo.model.*;
import org.example.roomtwo.model.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    LikeRepo likeRepo;
    @Autowired
    PhotoRepo photoRepo;
    @Autowired
    Cart_itemsRepo cartItemsRepo;
    


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    public Result createProduct(ProductDto productDto) {
        boolean existsbyname = productRepo.existsByName(productDto.getName());
        if (existsbyname) {
            return new Result(false, "Product already exists");
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setSize(productDto.getSize());
        product.setPrice(productDto.getPrice());
        product.setStatus(Status.ACTIVE);

        Optional<Like> likeOptional = likeRepo.findById(productDto.getLike_id());
        Like like = likeOptional.get();

        Optional<Photo> photoOptional = photoRepo.findById(productDto.getLike_id());
        Photo photo = photoOptional.get();

        Optional<Cart_Items> cartItemsOptional = cartItemsRepo.findById(productDto.getCart_items());
        Cart_Items cartItems = cartItemsOptional.get();



        product.setLike_id((List<Like>) like);
        product.setPhoto_id((List<Photo>) photo);
        product.setCart_items((List<Cart_Items>) cartItems);
        productRepo.save(product);
        return new Result(true, "Product created");


    }

    public Result updateProduct(Integer id , ProductDto productDto) {

        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setSize(productDto.getSize());
            product.setPrice(productDto.getPrice());

            Optional<Like> likeOptional = likeRepo.findById(productDto.getLike_id());
            Like like = likeOptional.get();

            Optional<Photo> photoOptional = photoRepo.findById(productDto.getLike_id());
            Photo photo = photoOptional.get();

            Optional<Cart_Items> cartItemsOptional = cartItemsRepo.findById(productDto.getCart_items());
            Cart_Items cartItems = cartItemsOptional.get();

            product.setLike_id((List<Like>) like);
            product.setPhoto_id((List<Photo>) photo);
            product.setCart_items((List<Cart_Items>) cartItems);
            productRepo.save(product);
            return new Result(true, "Product updated");
        }
        return new Result(false, "Product not found");
    }

    public Result deleteProduct(Integer id) {
        productRepo.deleteById(id);
        return new Result(true, "Product deleted");
    }
}
