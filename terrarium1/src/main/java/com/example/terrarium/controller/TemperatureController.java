package com.example.terrarium.controller;


import com.example.terrarium.model.Temperature;
import com.example.terrarium.model.dto.TemperatureData;
import com.example.terrarium.service.TemperatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TemperatureController {

    private TemperatureService temperatureService;

    @PostMapping("/temperature-data")
    public ResponseEntity<String> handleSensorData(@RequestBody TemperatureData data) {
        temperatureService.recordTemperature(data.getTemperature());
        return ResponseEntity.ok("Data received successfully!");
    }

    //TODO Temperature Data Fetching in Array Format (List)
    @GetMapping("/fetching-single-temperature-value")
        public ResponseEntity<Temperature> fetchingSingleTemperatureValue() {
        return temperatureService.fetchingSingleTemperatureValue();
    }



    @GetMapping("/fetching-cumulative-temperature")
    public ResponseEntity<List<Temperature>> fetchingCumulativeTemperatureValues() {
        return temperatureService.fetchingCumulativeTemperatureValues();
    }
}
