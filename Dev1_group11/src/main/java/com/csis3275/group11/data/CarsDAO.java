package com.csis3275.group11.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csis3275.group11.model.Car;



@Service
@Transactional
public class CarsDAO 
{
	@Autowired
	private CarRepository carRepository;
	
	public Car createCar(Car newCar)
	{
		return carRepository.save(newCar);
	}
	
	public List<Car> listAllCars()
	{
		return (List<Car>)carRepository.findAll();
	}
	
	public Car findCarById(Long id)
	{
		return carRepository.findById(id).orElse(new Car());
	}
	
	public Car saveCar(Car carToSave)
	{
		return carRepository.save(carToSave);
	}
}
