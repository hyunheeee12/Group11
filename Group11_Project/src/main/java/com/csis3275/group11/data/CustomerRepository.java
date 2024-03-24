package com.csis3275.group11.data;

import org.springframework.data.repository.CrudRepository;

import com.csis3275.group11.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
