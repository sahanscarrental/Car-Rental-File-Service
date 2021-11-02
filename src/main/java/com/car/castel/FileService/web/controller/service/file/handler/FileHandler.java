package com.car.castel.FileService.web.controller.service.file.handler;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileHandler {
    String save(MultipartFile file) throws Exception;
    byte[] retrieveFile(String path) throws IOException;
}
