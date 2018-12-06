package com.example.CourseBookingSystem.repositories.CourseRepository;

import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;



public class CourseRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getCoursesByRating(int rating){
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("rating",rating));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Course> getCoursesByCustomer(Long id){
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings","booking");
//            cr.createAlias("booking",)
            cr.add(Restrictions.eq("booking.customer.id",id));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return results;
    }


}
