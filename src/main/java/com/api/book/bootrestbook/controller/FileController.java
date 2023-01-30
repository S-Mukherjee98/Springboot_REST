package com.api.book.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadingHelper;

@RestController
public class FileController {


    @Autowired
    private FileUploadingHelper fileUploadingHelper;


    @PostMapping("/file-upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getName());

        

        //Validation.

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
            }
    
            // if(!file.getContentType().equals("image/jpg")){
    
            //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpg type is allowed");
            // }
    
            //file upload code
           boolean b= fileUploadingHelper.uploadFile(file);
           if (b) {
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Upload Unsuccessfull");
    }
}
