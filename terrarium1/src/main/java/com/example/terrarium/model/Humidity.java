package com.example.terrarium.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
@Builder
@Document(collection = "humidityLevels")
@AllArgsConstructor
public class Humidity {

    @Id
    private String id;

    @Field
    private double humidityLevel;
    @Field
    private Date date;



}
