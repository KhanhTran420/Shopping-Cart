package com.example.springbootshoppingcart.service.impl;

import com.example.springbootshoppingcart.exception.UploadFailException;
import com.example.springbootshoppingcart.model.Product;
import com.example.springbootshoppingcart.model.dto.ProductDto;
import com.example.springbootshoppingcart.model.filetype.NewContentType;
import com.example.springbootshoppingcart.repository.ProductRepository;
import com.example.springbootshoppingcart.service.ProductService;
import com.example.springbootshoppingcart.service.UploadFileService;
import com.example.springbootshoppingcart.utils.ImageUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final UploadFileService uploadFileService;

    private final ProductRepository productRepository;

    private final ImageUpload imageUpload;

//    @Value("https://media.global.com.vn/")
//    private String fileURL;
//    private static final int MAXIMUM_SIZE_IMAGE = 15;
//    private static final int PARAM_CONVERT_BYTES_TO_MB = 1024*1024;
//    private static final int MINIMUM_WIDTH_IMAGE = 1440;
//    private static final int MINIMUM_HEIGHT_IMAGE = 580;
//
//    private final List<String> listFileType = Arrays.asList("png","jpg","jpeg");
//    private final List<String> listTypeVideo = Arrays.asList("mp4");

    @Override
    public Product createProduct(ProductDto productDto, MultipartFile file)  {
        Product product = new Product();
        try {
            if (file == null) {
                product.setImage(null);
            } else {
                imageUpload.uploadFile(file);
                product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCostPrice(productDto.getCostPrice());
        product.setCurrentQuantity(productDto.getCurrentQuantity());
        product.setSalePrice(productDto.getSalePrice());
        product.set_activated(true);
        product.set_deleted(false);
        product.setCategory(productDto.getCategory());
            return productRepository.save(product);

//        if (Objects.nonNull(file)){
//            validateFile(file, productDto.getNewContentType());
//            //upload file
//            product.setImage(uploadFileService.uploadFile("OTHER",file).getPreviewUrl());
//        }
//        return productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

//    private void validateFile(MultipartFile file, NewContentType type) throws UploadFailException {
//        String [] fileTypeArr = Objects.requireNonNull(file.getOriginalFilename())
//                .split("\\.");
//        String fileType = fileTypeArr[fileTypeArr.length - 1]
//                .toLowerCase();
//
//        if (type.equals(NewContentType.VIDEO)){
//            if (!listTypeVideo.contains(fileType)){
//                throw new UploadFailException("error");
//            }
//            if ((file.getSize()/(float) PARAM_CONVERT_BYTES_TO_MB > 200)){
//                throw new UploadFailException("error");
//            }
//            return;
//        }
//        try {
//            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
//
//            if (listTypeVideo.contains(fileType)){
//                if ((file.getSize()/(float) PARAM_CONVERT_BYTES_TO_MB >200)){
//                    throw new UploadFailException("error");
//                }
//                return;
//            }
//            if (bufferedImage.getWidth() < MINIMUM_WIDTH_IMAGE || bufferedImage.getHeight() < MINIMUM_HEIGHT_IMAGE){
//                throw new UploadFailException("error");
//            }
//            if (file.getSize()/(float) PARAM_CONVERT_BYTES_TO_MB > MAXIMUM_SIZE_IMAGE || !listFileType.contains(fileType)){
//                throw new UploadFailException("error");
//            }
//        } catch (IOException e) {
//            throw new UploadFailException("ko the upload tep tin");
//        }
//    }

}
