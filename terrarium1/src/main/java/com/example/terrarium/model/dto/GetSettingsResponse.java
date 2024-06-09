package com.example.terrarium.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSettingsResponse {

    private Double temperatureThreshold;
    private Double humidityThreshold;

}
