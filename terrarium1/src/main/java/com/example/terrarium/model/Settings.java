package com.example.terrarium.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "settings")
@AllArgsConstructor
@NoArgsConstructor
public class Settings {
    @Id
    private String id;

    private String settingType;
    private double humidityThreshold;
    private double temperatureThreshold;
    private Date date;
}
