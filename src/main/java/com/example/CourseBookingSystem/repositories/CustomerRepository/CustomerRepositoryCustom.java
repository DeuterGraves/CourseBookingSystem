package com.example.CourseBookingSystem.repositories.CustomerRepository;

import com.example.CourseBookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> getCustomerByCourse(Long id);
    List<Customer> getCustomerByTownAndCourse(String town, Long courseId);

    List<Customer> getCustomerOverageinTownInCourse(int age,String town, Long courseId);
}
