package com.example.CourseBookingSystem.repositories.CustomerRepository;

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

public class CustomerRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getCustomerByCourse(Long id){
        List<Customer> results = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings","booking");
//            cr.createAlias("booking",)
            cr.add(Restrictions.eq("booking.course.id",id));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return results;

    }

    @Transactional
    public List<Customer> getCustomerByTownAndCourse(String town, Long courseId){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            cr.add(Restrictions.ilike("town", town));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Customer> getCustomerOverageinTownInCourse(int age,String town, Long courseId) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.gt("age",age));
            cr.add(Restrictions.ilike("town",town));
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
