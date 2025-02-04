package com.tpe.controller;

import com.tpe.dto.CarSaveDTO;
import com.tpe.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private CarService carService;

//    http://localhost:8085/car/ + POST + JSON body
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveCar(@RequestBody CarSaveDTO dto) {

        carService.saveCar(dto);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Car:" + dto.getBrand() + " " + dto.getModel() + " saved successfully.");
        return  new ResponseEntity<>(map, HttpStatus.CREATED);  //201
    }
}
