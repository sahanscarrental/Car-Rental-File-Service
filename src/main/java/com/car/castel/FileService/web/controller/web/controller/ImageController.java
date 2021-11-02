package com.car.castel.FileService.web.controller.web.controller;

import com.car.castel.FileService.web.controller.service.impl.FileService;
import com.car.castel.FileService.web.controller.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<ApiResponse> create( @RequestParam("file") MultipartFile file) throws Exception{
        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .message("Uploaded")
                .body(fileService.saveAFile(file))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> get(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(fileService.retrieveFile(id));
    }

    @GetMapping("/email-image/{id}")
    public ResponseEntity<ApiResponse> getEmailImage(@PathVariable UUID id) throws Exception{
//        return ResponseEntity.ok(fileService.retrieveFile(id));
        return ResponseEntity.ok(ApiResponse
                .builder()
                .status(true)
                .timestamp(new Date())
                .message("Uploaded")
                .body(fileService.retrieveFileForImage(id))
                .build());
    }
}
