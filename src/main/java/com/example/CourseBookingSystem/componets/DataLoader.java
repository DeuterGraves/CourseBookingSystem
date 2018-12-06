package com.example.CourseBookingSystem.componets;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){ }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("Susan Rumplenton", "Edinburgh", 25);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("George Hamington", "London", 32);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Simon Watson", "Belfast", 38);
        customerRepository.save(customer3);

        Course course2 = new Course("Intro to Kickboxing", "Edinburgh", 5);
        courseRepository.save(course2);

        Course course1 = new Course("Intermediate Astronomy", "London", 2);
        courseRepository.save(course1);

        Booking booking1 = new Booking("12-12-2018", customer1, course2);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("15-01-2019", customer2, course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("15-01-2019", customer3, course1);
        bookingRepository.save(booking3);


    }


}
