package com.example.terrarium.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@Document(collection = "temperatureLevels")
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {

    @Id
    private String id;

    @Field
    private double temperatureLevel;
    @Field
    private Date date;


}
