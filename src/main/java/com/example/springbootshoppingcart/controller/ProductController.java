package com.example.springbootshoppingcart.controller;

import com.example.springbootshoppingcart.model.BaseResponse;
import com.example.springbootshoppingcart.model.Product;
import com.example.springbootshoppingcart.model.dto.ProductDto;
import com.example.springbootshoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createProduct(@RequestBody ProductDto productDto, @RequestParam("file") MultipartFile file) throws IOException {
        Product product = productService.createProduct(productDto,file);
        return new ResponseEntity<>(new BaseResponse("create success", product), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product> products = productService.findAllProduct();
        return new  ResponseEntity<>(products,HttpStatus.OK);
    }
}
