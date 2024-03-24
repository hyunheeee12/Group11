package com.csis3275.group11.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="car")
public class Car 
{
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String make;
	private String model;
	private String yearMade;
	private String color;
	private double price;
	private Boolean have;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	private LocalDate soldDate;
	
	public Car() {
		super();
	}
	
	

	public Car(String make, String model, String yearMade, String color, double price, Boolean have,
			LocalDate soldDate) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearMade = yearMade;
		this.color = color;
		this.price = price;
		this.have = have;
		this.soldDate = soldDate;
	}



	/*
	 * public Car(String make, String model, String year, String color, double
	 * price) { super(); this.make = make; this.model = model; this.yearMade = year;
	 * this.color = color; this.price = price; this.have = have; }
	 */

	public Long getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearMade() {
		return yearMade;
	}

	public void setYearMade(String year) {
		this.yearMade = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Boolean getHave() {
		return have;
	}

	public void setHave(Boolean have) {
		this.have = have;
	}

	public LocalDate getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	
	
}
