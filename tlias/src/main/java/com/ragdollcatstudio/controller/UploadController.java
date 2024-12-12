package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("upload");
        String originalFilename = image.getOriginalFilename();
        int idx = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(idx);
        String newFileName = UUID.randomUUID().toString() + suffix;
        log.info("{}", newFileName);
        image.transferTo(new File("D:\\Project\\Java\\JavaServerDevLearn\\src\\img\\tlias"+newFileName));
        return Result.success();
    }
}
