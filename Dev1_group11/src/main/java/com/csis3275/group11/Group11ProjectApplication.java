package com.csis3275.group11;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.group11.data.CarsDAO;
import com.csis3275.group11.data.CustomerDAO;
import com.csis3275.group11.model.Car;
import com.csis3275.group11.model.Customer;

@SpringBootApplication
public class Group11ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group11ProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner carDemo(CarsDAO dao)
	{
		return (args) ->
		{
			dao.createCar(new Car("Ford", "F-150", "2015", "White", 16666.99, false, LocalDate.parse("2023-11-11")));
			dao.createCar(new Car("Ford", "Flex", "2011", "Blue", 8666.99, false, LocalDate.parse("2023-11-12")));
			dao.createCar(new Car("Ford", "Fusion", "2010", "Grey", 4666.99, true, null));
			dao.createCar(new Car("Kia", "Sorento", "2012", "White", 7666.99, true, null));
			dao.createCar(new Car("Dodge", "Durango", "2020", "Black", 19666.99, true, null));
			dao.createCar(new Car("Dodge", "Caravan", "2018", "Silver", 11666.99, false, LocalDate.parse("2023-11-16")));
			dao.createCar(new Car("BYD", "Han", "2022", "Red", 31666.99, true, null));
			dao.createCar(new Car("Kia", "Soul", "2016", "White", 5666.99, false, LocalDate.parse("2023-11-18")));
			dao.createCar(new Car("Kia", "Sportage", "2017", "Blue", 9666.99, false, LocalDate.parse("2023-11-19")));
			dao.createCar(new Car("BMW", "X5", "2019", "Black", 22666.99, true, null));
		};
	}
	
	@Bean
	CommandLineRunner customerDemo(CustomerDAO dao)
	{
		return (args) ->
		{
			dao.createCustomer(new Customer("Amy", "Ao", "aa@myemail.ca", "8885956", LocalDate.parse("2019-10-03"), "5678"));
			dao.createCustomer(new Customer("Bob", "Bring", "bb@myemail.ca", "3336768", LocalDate.parse("2020-11-04"), "5678"));
			dao.createCustomer(new Customer("Cole", "Cai", "cc@myemail.ca", "6662123", LocalDate.parse("2021-12-05"), "5678"));
			dao.createCustomer(new Customer("David", "Doug", "dd@myemail.ca", "5553237", LocalDate.parse("2022-01-06"), "5678"));
			dao.createCustomer(new Customer("Emily", "Emma", "ee@myemail.ca", "9997675", LocalDate.parse("2023-02-07"), "5678"));
			dao.createCustomer(new Customer("Flora", "Faye", "ff@myemail.ca", "4448680", LocalDate.parse("2024-03-08"), "5678"));
		};
	}

}
