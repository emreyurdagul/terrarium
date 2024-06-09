package com.example.terrarium.repository;

import com.example.terrarium.model.Temperature;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, String> {
    List<Temperature> findByDateBefore(Date targetDate, Pageable pageable);

    List<Temperature> findAllByOrderByDateDesc(Pageable limit);
}
