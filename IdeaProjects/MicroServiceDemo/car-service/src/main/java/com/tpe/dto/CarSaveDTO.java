package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarSaveDTO {

    private String brand;

    private String model;

    private Integer doors;

    private Integer age;

    private Double pricePerHour;
}
