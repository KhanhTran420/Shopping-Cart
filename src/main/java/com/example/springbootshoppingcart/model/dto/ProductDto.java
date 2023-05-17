package com.example.springbootshoppingcart.model.dto;

import com.example.springbootshoppingcart.model.Category;
import com.example.springbootshoppingcart.model.filetype.NewContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int currentQuantity;
    private double costPrice;
    private double salePrice;
    private String image;
    private Category category;
    private boolean activated;
    private boolean deleted;
//    private NewContentType newContentType;
}
