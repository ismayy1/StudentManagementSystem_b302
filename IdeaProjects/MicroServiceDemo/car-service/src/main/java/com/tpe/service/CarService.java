package com.tpe.service;

import com.netflix.discovery.EurekaClient;
import com.tpe.domain.Car;
import com.tpe.dto.AppLogDTO;
import com.tpe.dto.CarSaveDTO;
import com.tpe.enums.AppLogLevel;
import com.tpe.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private ModelMapper modelMapper;
    private EurekaClient eurekaClient;
    private RestTemplate restTemplate;

    public void saveCar(CarSaveDTO dto) {
        Car car = modelMapper.map(dto, Car.class);

        carRepository.save(car);

//        LOGGING OPERATOR
        String baseUrl = eurekaClient
                .getApplication("log-service")
                .getInstances().get(0)
                .getHomePageUrl();

        String endPoint = baseUrl + "/log";

        AppLogDTO appLogDTO = new AppLogDTO();
        appLogDTO.setLevel(AppLogLevel.INFO.name());    // creating the getter method in enum is redundant
        appLogDTO.setDescription("Car: " + car.getBrand() + " " + car.getModel() + " saved successfully!");
        appLogDTO.setCreatedAt(LocalDateTime.now());

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(endPoint, appLogDTO, Map.class);

        if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException("Log couldn't be created!");
        }
    }
}
