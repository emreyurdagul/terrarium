package com.example.terrarium.repository;

import com.example.terrarium.model.Humidity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends MongoRepository<Humidity, String> {
}
