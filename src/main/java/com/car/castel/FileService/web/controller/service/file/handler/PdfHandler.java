package com.car.castel.FileService.web.controller.service.file.handler;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PdfHandler implements FileHandler {
    @Override
    public String save(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public byte[] retrieveFile(String path) {
        return null;
    }

}
