package com.car.castel.FileService.web.controller.service.impl;

import com.car.castel.FileService.web.controller.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface FileService {
    Image saveAFile(MultipartFile file) throws IOException;
    byte[] retrieveFile(UUID id) throws IOException;
    String retrieveFileForImage(UUID id) throws IOException;
}
