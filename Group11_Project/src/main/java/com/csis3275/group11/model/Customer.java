package com.csis3275.group11.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String fName;
	private String lName;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String dLicence;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;
	
	private String password;

	public Customer() {
		super();
	}

	public Customer(String fName, String lName, String email, String dLicence, LocalDate joinDate, String pw) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.dLicence = dLicence;
		this.joinDate = joinDate;
		password = pw;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdLicence() {
		return dLicence;
	}

	public void setdLicence(String dLicence) {
		this.dLicence = dLicence;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Long getId() {
		return Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
