package com.example.springbootshoppingcart.service;

import com.example.springbootshoppingcart.exception.UploadFailException;
import com.example.springbootshoppingcart.model.dto.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    FileDto uploadFile(String fileType, MultipartFile file) throws IOException, UploadFailException;
}
