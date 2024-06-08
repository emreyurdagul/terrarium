package com.example.terrarium.service;

import com.example.terrarium.model.Temperature;
import com.example.terrarium.repository.TemperatureRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@AllArgsConstructor
public class TemperatureService {


    private TemperatureRepository temperatureRepository;

    public void recordTemperature(double temperature){
        LocalDateTime localDateTime = LocalDateTime.now(); // Current date and time
        Date currentDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()); // Convert LocalDateTime to Date
        Temperature temperature1 = Temperature.builder()
                .temperatureLevel(temperature)
                .date(currentDate)
                .build();
        temperatureRepository.save(temperature1);


    }
}
