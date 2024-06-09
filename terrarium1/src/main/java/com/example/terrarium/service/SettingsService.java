package com.example.terrarium.service;


import com.example.terrarium.model.Settings;
import com.example.terrarium.model.dto.GetSettingsResponse;
import com.example.terrarium.model.dto.SetHumidityThresholdRequest;
import com.example.terrarium.model.dto.SetTemperatureThresholdRequest;
import com.example.terrarium.repository.SettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository settingsRepository;
    public void setTemperatureThreshold(SetTemperatureThresholdRequest temperatureThresholdRequest) {
        Optional<Settings> settingsOptional = settingsRepository.findBySettingType("threshold");
        Settings settings;
        if(settingsOptional.isEmpty()) {
            settings = Settings.builder()
                    .temperatureThreshold(temperatureThresholdRequest.getTemperatureThreshold())
                    .humidityThreshold(25.0)
                    .settingType("threshold")
                    .build();
        }else {
            settings = settingsOptional.get();
            settings.setTemperatureThreshold(temperatureThresholdRequest.getTemperatureThreshold());
        }
        settingsRepository.save(settings);
    }

    public void setHumidityThreshold(SetHumidityThresholdRequest humidityThresholdRequest) {
        Optional<Settings> settingsOptional = settingsRepository.findBySettingType("threshold");
        Settings settings;
        if(settingsOptional.isEmpty()) {
            settings = Settings.builder()
                    .temperatureThreshold(25.0)
                    .humidityThreshold(humidityThresholdRequest.getHumidityThreshold())
                    .settingType("threshold")
                    .build();
        }else {
            settings = settingsOptional.get();
            settings.setHumidityThreshold(humidityThresholdRequest.getHumidityThreshold());
        }
        settingsRepository.save(settings);
    }



    public GetSettingsResponse getSettings() {
        Optional<Settings> settingsOptional = settingsRepository.findBySettingType("threshold");
        if (settingsOptional.isPresent()) {
            Settings settings = settingsOptional.get();
            return new GetSettingsResponse(
                    settings.getTemperatureThreshold(),
                    settings.getHumidityThreshold()
            );
        } else {
            // Handling the case where no settings are found; you might want to handle this differently
            return new GetSettingsResponse(25.0, 50.0); // default values
        }
    }




}
