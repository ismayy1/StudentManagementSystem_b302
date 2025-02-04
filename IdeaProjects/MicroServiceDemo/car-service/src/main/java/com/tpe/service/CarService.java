package com.tpe.service;

import com.tpe.domain.Car;
import com.tpe.dto.CarSaveDTO;
import com.tpe.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private ModelMapper modelMapper;

    public void saveCar(CarSaveDTO dto) {
        Car car = modelMapper.map(dto, Car.class);

        carRepository.save(car);
    }
}
