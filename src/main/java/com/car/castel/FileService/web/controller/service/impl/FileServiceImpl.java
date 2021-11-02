package com.car.castel.FileService.web.controller.service.impl;

import com.car.castel.FileService.web.controller.entity.Image;
import com.car.castel.FileService.web.controller.repository.ImageRepository;
import com.car.castel.FileService.web.controller.service.file.handler.FileFactory;
import com.car.castel.FileService.web.controller.service.file.handler.FileHandler;
import com.car.castel.FileService.web.controller.web.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private ImageRepository  imageRepository;

    @Autowired
    private FileFactory fileFactory;

    @Override
    public Image saveAFile(MultipartFile file) throws IOException {
        FileHandler fileHandler = fileFactory.fileHandlerInstance(file);
        try{
            String path = fileHandler.save(file);
            Image image = new Image();
            image.setPath(path);
            return imageRepository.save(image);
        }catch (IOException e){ // TODO
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] retrieveFile(UUID id) throws IOException {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()){
            Image image = optionalImage.get();
            FileHandler fileHandler = fileFactory.fileHandlerInstance(image.getPath());
            return fileHandler.retrieveFile(image.getPath());
        } else {
            throw new EntityNotFoundException(Image.class,"id",id.toString());
        }
    }

    @Override
    public String retrieveFileForImage(UUID id) throws IOException {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()){
            Image image = optionalImage.get();
            FileHandler fileHandler = fileFactory.fileHandlerInstance(image.getPath());
            String fileData = Base64.getEncoder().encodeToString(fileHandler.retrieveFile(image.getPath()));
           // String fileData = new String(fileHandler.retrieveFile(image.getPath()), StandardCharsets.UTF_8);
            return fileData;
        }else {
            throw new EntityNotFoundException(Image.class,"id",id.toString());
        }
    }
}
