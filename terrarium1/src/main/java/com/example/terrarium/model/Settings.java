package com.example.terrarium.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "settings")
@AllArgsConstructor
@NoArgsConstructor
public class Settings {

    private double humidityThreshold;
    private double temperatureThreshold;
    private Date date;
}
