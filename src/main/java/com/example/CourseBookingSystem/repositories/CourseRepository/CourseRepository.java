package com.example.CourseBookingSystem.repositories.CourseRepository;

import com.example.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
