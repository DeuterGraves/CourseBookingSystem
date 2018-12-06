package com.example.CourseBookingSystem.repositories.CustomerRepository;

import com.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
