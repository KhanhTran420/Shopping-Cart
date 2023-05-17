package com.example.springbootshoppingcart.service;

import com.example.springbootshoppingcart.model.Product;
import com.example.springbootshoppingcart.model.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto, MultipartFile file) throws IOException;

    List<Product> findAllProduct();
}
