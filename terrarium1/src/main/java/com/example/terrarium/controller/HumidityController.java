package com.example.terrarium.controller;

import com.example.terrarium.model.dto.HumidityData;
import com.example.terrarium.service.HumidityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/humidity")
@AllArgsConstructor
public class HumidityController {

    private final HumidityService humidityService;

    @PostMapping("/humidity-data")
    public ResponseEntity<String> handleSensorData(@RequestBody HumidityData data) {
        humidityService.recordHumidity(data.getHumidity());
        return ResponseEntity.ok("Data received successfully!");
    }


}

