package com.example.CourseBookingSystem;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetCoursesbyRating(){
		List<Course> result = courseRepository.getCoursesByRating(2);
		assertEquals(1, result.size());
		assertEquals("Intermediate Astronomy", result.get(0).getName());
	}

	@Test
	public void canGetCourseByCustomer(){
		List<Course> result = courseRepository.getCoursesByCustomer(1L);
		assertEquals(1, result.size());
	}

	@Test
    public void canGetCustomerByCourse(){
	    List<Customer> result = customerRepository.getCustomerByCourse(1L);
	    assertEquals(1, result.size());
    }

    @Test
    public void canGetBookingByDate(){
	    List<Booking> result = bookingRepository.getBookingByDate("12-12-2018");
	    assertEquals(1, result.size());
     }

}
