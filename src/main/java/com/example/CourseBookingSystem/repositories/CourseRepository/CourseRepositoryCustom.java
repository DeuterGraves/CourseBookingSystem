package com.example.CourseBookingSystem.repositories.CourseRepository;

import com.example.CourseBookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> getCoursesByRating(int rating);

    List<Course> getCoursesByCustomer(Long id);
}
