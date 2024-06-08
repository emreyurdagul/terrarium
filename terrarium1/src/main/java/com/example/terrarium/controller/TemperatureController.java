package com.example.terrarium.controller;


import com.example.terrarium.model.Temperature;
import com.example.terrarium.model.dto.TemperatureData;
import com.example.terrarium.service.TemperatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
@AllArgsConstructor
public class TemperatureController {

    private TemperatureService temperatureService;

    @PostMapping("/temperature-data")
    public ResponseEntity<String> handleSensorData(@RequestBody TemperatureData data) {
        temperatureService.recordTemperature(data.getTemperature());
        return ResponseEntity.ok("Data received successfully!");
    }
}
