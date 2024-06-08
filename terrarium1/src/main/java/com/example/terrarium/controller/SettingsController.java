package com.example.terrarium.controller;

import com.example.terrarium.model.dto.SetHumidityThresholdRequest;
import com.example.terrarium.model.dto.SetTemperatureThresholdRequest;
import com.example.terrarium.service.SettingsService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class SettingsController {

    private SettingsService settingsService;
    @PostMapping("/temperature-threshold")
    public ResponseEntity<String> setTemperatureThreshold(@RequestBody SetTemperatureThresholdRequest temperatureThresholdRequest) {
        settingsService.setTemperatureThreshold(temperatureThresholdRequest);
        return ResponseEntity.ok("temperatureThreshold is changed");
    }

    @PostMapping("/humidity-threshold")
    public ResponseEntity<String> setHumidityThreshold(@RequestBody SetHumidityThresholdRequest humidityThresholdRequest) {
        settingsService.setHumidityThreshold(humidityThresholdRequest);
        return ResponseEntity.ok("humidityThreshold is changed");
    }

}
