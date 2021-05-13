package com.stu.luanvan.controller.admin;

import com.stu.luanvan.service.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private CloudinaryService cloudinaryService;
    @PostMapping
    private ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String message = null;
        try{
            var url = cloudinaryService.uploadFile(file);
            message = "Uploaded the file successfully: " + url;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch(Exception e){
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}
