package com.example.terrarium.repository;

import com.example.terrarium.model.Humidity;
import com.example.terrarium.model.Temperature;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidityRepository extends MongoRepository<Humidity, String> {

    List<Humidity> findAllByOrderByDateDesc(Pageable pageable);
}
