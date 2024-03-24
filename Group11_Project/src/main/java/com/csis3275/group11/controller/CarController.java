package com.csis3275.group11.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.group11.data.CarsDAO;
import com.csis3275.group11.model.Car;


@Controller
@Transactional
public class CarController 
{
	
	private final CarsDAO carService;

    @Autowired
    public CarController(CarsDAO carService) {
        this.carService = carService;
    }
    
	@GetMapping("/buy/carlist")
	public String listAllCars(Model model)
	{
		model.addAttribute("carList", carService.listAllCars());
//		model.addAttribute("newCar", new Car());
		return "customer/carlist";
	}
	
	@GetMapping("/")
	public String home()	{
		return "redirect:/buy/carlist";
	}
	
	@GetMapping("/buy/carsold")
	public String listSoldCars(Model model)
	{
		model.addAttribute("carList", carService.listAllCars());
		return "carsold";
	}
	
	@GetMapping("/dash")
	public String goDash()
	{
		return "dashboard";
	}
	
	@GetMapping("/showcar")
	public String showCar(Model model)
	{
		model.addAttribute("carList", carService.listAllCars());
		return "carlist";
	}
	
	@GetMapping("/buycar")
	public String buyCar()
	{
//		Car carToBuy = carService.findCarById(id);
//		if (carToBuy == null)
//	        return "redirect:/error";
//		model.addAttribute("carToBuy", carToBuy);
//		carToBuy.setHave(false);
		return "customer/gotcar";
	}
	
	@PostMapping("/buycar")
	public String buyCar(@RequestParam("id") Long id, Model model)
	{
		Car carToBuy = carService.findCarById(id);
		carToBuy.setHave(false);
		carToBuy.setSoldDate(LocalDate.now());
		carService.saveCar(carToBuy);
		return "customer/gotcar";
	}
}
