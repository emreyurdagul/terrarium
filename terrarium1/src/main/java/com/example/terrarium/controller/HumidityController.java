package com.example.terrarium.controller;

import com.example.terrarium.model.Humidity;
import com.example.terrarium.model.dto.HumidityData;
import com.example.terrarium.service.HumidityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humidity")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class HumidityController {

    private final HumidityService humidityService;

    @PostMapping("/humidity-data")
    public ResponseEntity<String> handleSensorData(@RequestBody HumidityData data) {
        humidityService.recordHumidity(data.getHumidity());
        return ResponseEntity.ok("Data received successfully!");
    }

    //TODO Humidity Data Fetching

    @GetMapping("/fetch-single-humidity-value")
    public ResponseEntity<Humidity> fetchHumidityValue(){
        return humidityService.fetchHumidityValue();
    }

}

