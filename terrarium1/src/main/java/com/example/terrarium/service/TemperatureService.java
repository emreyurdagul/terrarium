package com.example.terrarium.service;

import com.example.terrarium.model.Humidity;
import com.example.terrarium.model.Temperature;
import com.example.terrarium.repository.TemperatureRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    //TODO Sonra gelip gösterme özelliğini bir üst seviyeye çıkarmaya çalışacağız.
    public ResponseEntity<List<Temperature>> fetchingCumulativeTemperatureValues() {
        Date date = new Date();
        Pageable pageable = PageRequest.of(0, 500, Sort.by("date").descending());
        List<Temperature> temperatures =  temperatureRepository.findByDateBefore(date, pageable);
        return ResponseEntity.ok(temperatures);
    }

    public ResponseEntity<Temperature> fetchingSingleTemperatureValue() {
        Pageable limit = PageRequest.of(0, 1, Sort.by("date").descending());
        List<Temperature> temperatures = temperatureRepository.findAllByOrderByDateDesc(limit);
        return temperatures.isEmpty() ? ResponseEntity.ok(Temperature.builder().temperatureLevel(0.0).date(new Date()).build())  : ResponseEntity.ok(temperatures.get(0));

    }
}
