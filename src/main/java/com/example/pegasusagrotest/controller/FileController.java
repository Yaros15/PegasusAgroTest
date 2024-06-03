package com.example.pegasusagrotest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/files")
public class FileController {

    @PostMapping
    public int uploadFile(@RequestPart MultipartFile file){
        int numLinesInFile = 0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            //reader.lines();
            while (reader.readLine() != null){
                numLinesInFile++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return numLinesInFile;
    }

}
