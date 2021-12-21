package com.example.project.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static void moveImageToResource(MultipartFile image) throws IOException {
        File uploadDir = new File("/usr/local/fengqihang/static/img/");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //TODO
        File uploadFile = new File("/usr/local/fengqihang/static/img/"
                + image.getOriginalFilename());
        image.transferTo(uploadFile);
    }


}
