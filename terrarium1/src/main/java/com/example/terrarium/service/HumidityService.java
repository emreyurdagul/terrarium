package com.example.terrarium.service;

import com.example.terrarium.model.Humidity;
import com.example.terrarium.model.Temperature;
import com.example.terrarium.repository.HumidityRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@AllArgsConstructor
public class HumidityService {
    private HumidityRepository humidityRepository;


    public void recordHumidity(double humidity) {

        LocalDateTime localDateTime = LocalDateTime.now(); // Current date and time
        Date currentDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()); // Convert LocalDateTime to Date
        Humidity humidity1 = Humidity.builder()
                .humidityLevel(humidity)
                .date(currentDate)
                .build();
        humidityRepository.save(humidity1);



    }
}
