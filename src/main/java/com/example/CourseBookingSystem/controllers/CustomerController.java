package com.example.CourseBookingSystem.controllers;


import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{id}")
    public List<Customer> getCustomerByCourse(@PathVariable Long id){
        return customerRepository.getCustomerByCourse(id);
    }

    @GetMapping(value = "/town/{town}/course/{id}")
    public List<Customer> getCustomerByTownandCourse(@PathVariable String town, @PathVariable Long id){
        return customerRepository.getCustomerByTownAndCourse(town, id);
    }

    @GetMapping(value = "/age/{age}/town/{town}/course/{id}")
    public List<Customer> getCustomerOverAgeInTownOnCourse(@PathVariable int age,@PathVariable String town,@PathVariable Long id){
        return customerRepository.getCustomerOverageinTownInCourse(age,town,id);
    }


}
