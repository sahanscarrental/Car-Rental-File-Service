package com.car.castel.FileService.web.controller.service.file.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileFactory {


    @Autowired
    private ImageHandler imageHandler;

    public  FileHandler fileHandlerInstance(MultipartFile file){
        switch (getExtension(file)){
            case ".pdf":
                return new PdfHandler();
            case ".png":
            case ".PNG":
            case ".JPG":
            case ".jpg":
            default:
                return imageHandler;
        }
    }

    public  FileHandler fileHandlerInstance(String path){
        String[] split = path.split("\\.");
        switch (split[split.length-1]){
            case ".pdf":
                return new PdfHandler();
            case ".png":
            case ".PNG":
            case ".JPG":
            case ".jpg":
            default:
                return imageHandler;
        }
    }

    public static  String getExtension(MultipartFile inFile) {
        String ex = inFile.getOriginalFilename().substring(inFile.getOriginalFilename().lastIndexOf('.'));
        return ex;
    }
}
