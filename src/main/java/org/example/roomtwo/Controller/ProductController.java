package org.example.roomtwo.Controller;

import org.example.roomtwo.Dto.ProductDto;
import org.example.roomtwo.Service.ProductService;
import org.example.roomtwo.model.Product;
import org.example.roomtwo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProductService() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getbyid (@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Result addproduct(@RequestBody ProductDto productDto) {
        Result result = productService.createProduct(productDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateproduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.updateProduct(id, productDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteproduct(@PathVariable Integer id) {
        Result result = productService.deleteProduct(id);
        return result;
    }
}
