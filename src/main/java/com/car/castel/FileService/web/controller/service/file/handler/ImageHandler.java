package com.car.castel.FileService.web.controller.service.file.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

@Component
public class ImageHandler implements FileHandler {

    @Value("${upload.path}")
    private String UPLOAD_DIR;

    @Override
    public String save(MultipartFile file) throws Exception { //TODO
        try {
            String fileExtension = getFileExtension(file);
            String filename = getRandomString();
            File targetFile = getTargetFile(fileExtension, filename);
            file.transferTo(targetFile);
            return filename+fileExtension;
        }catch (IOException e){
            e.printStackTrace();
            throw new Exception("Error in saving file");
        }
    }

    @Override
    public byte[] retrieveFile(String path) throws IOException {
        return Files.readAllBytes(new File(UPLOAD_DIR + path).toPath());
    }










    private String getRandomString() {
        return new Random().nextInt(999999) + "_" + System.currentTimeMillis();
    }

    private File getTargetFile(String fileExtn, String fileName) {
        return new File(UPLOAD_DIR + fileName + fileExtn);
    }

    private String getFileExtension(MultipartFile inFile) {
        return inFile.getOriginalFilename().substring(inFile.getOriginalFilename().lastIndexOf('.'));
    }
}
