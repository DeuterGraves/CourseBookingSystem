package com.example.CourseBookingSystem.controllers;


import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getByRating(@PathVariable int rating){
        return courseRepository.getCoursesByRating(rating);
    }

    @GetMapping(value = "/customer/{id}")
    public List<Course> getByCustomerID(@PathVariable Long id){
        return courseRepository.getCoursesByCustomer(id);
    }

}
