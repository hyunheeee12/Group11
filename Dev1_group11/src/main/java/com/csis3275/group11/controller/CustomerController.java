package com.csis3275.group11.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.query.EqlParser.New_valueContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.group11.data.CarsDAO;
import com.csis3275.group11.data.CustomerDAO;
import com.csis3275.group11.model.Customer;

@Controller
public class CustomerController 
{
	private final CustomerDAO customerService;

    @Autowired
    public CustomerController(CustomerDAO customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/customer/register")
    public String register(Model model)
    {
    	model.addAttribute("nCustomer", new Customer());
    	return "register";
    }
    
    @PostMapping("/customer/register")
	public String register(@ModelAttribute("nCustomer") Customer newCustomer, BindingResult result)
    {
		if (result.hasErrors()) {
	        // If there are validation errors, handle them (e.g., return to the registration form with error messages)
	        return "doctor/register";
	    }
		newCustomer.setJoinDate(LocalDate.now());
		customerService.createCustomer(newCustomer);
		return "redirect:/buy/carlist";
	}
}
