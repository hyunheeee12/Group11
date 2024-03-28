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
import org.springframework.web.bind.annotation.RequestParam;

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
	        return "/customer/register";
	    }
		
		if(newCustomer.getfName().equals("")||newCustomer.getlName().equals("")||newCustomer.getEmail().equals("")||newCustomer.getLicence().equals("")||newCustomer.getPassword().equals(""))
			return  "/customer/register";
		else {
			newCustomer.setJoinDate(LocalDate.now());
		customerService.createCustomer(newCustomer);
		return "redirect:/buy/carlist";
		}
		
	}
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new Customer());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("login") Customer login, Model model) {
        // Find the customer by email
        Customer customer = customerService.findByEmail(login.getEmail());

        if (customer != null && login.getPassword().equals(customer.getPassword())) {
            // Password matches, now check if the user is an employee
            boolean isEmployee = customer.isEmployee();

            if (isEmployee) {
                // If the user is an employee, redirect to the employee dashboard
                return "redirect:/dash";
            } else {
                // If the user is not an employee, redirect to the customer car list
                return "redirect:/buy/carlist";
            }
        } else {
            // If customer not found or password doesn't match, show error message
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
