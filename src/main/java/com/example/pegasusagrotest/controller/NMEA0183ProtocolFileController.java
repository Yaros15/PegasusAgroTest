package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.service.NMEA0183ProtocolFileService;
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
public class NMEA0183ProtocolFileController {

    @PostMapping
    public double uploadFile(@RequestPart MultipartFile file){
        NMEA0183ProtocolFileService fileService = new NMEA0183ProtocolFileService();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null){
                fileService.connectRouteUsingCoordinatesFromFile(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileService.carHasPassedWay();
    }

}
