package com.example.terrarium.service;

import com.example.terrarium.model.Humidity;
import com.example.terrarium.model.Temperature;
import com.example.terrarium.repository.HumidityRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class HumidityService {
    private HumidityRepository humidityRepository;


    public void recordHumidity(double humidity) {

        LocalDateTime localDateTime = LocalDateTime.now(); // Current date and time
        Date currentDate = Date.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant()); // Convert LocalDateTime to Date
        Humidity humidity1 = Humidity.builder()
                .humidityLevel(humidity)
                .date(currentDate)
                .build();
        humidityRepository.save(humidity1);



    }

    public ResponseEntity<Humidity> fetchHumidityValue() {
        Pageable limit = PageRequest.of(0, 1, Sort.by("date").descending());
        List<Humidity> humidities = humidityRepository.findAllByOrderByDateDesc(limit);
        return humidities.isEmpty() ? ResponseEntity.ok(Humidity.builder().humidityLevel(0.0).date(new Date()).build())  : ResponseEntity.ok(humidities.get(0));
    }
}
