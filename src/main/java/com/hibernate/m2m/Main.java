package com.hibernate.m2m;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;
            transaction = session.beginTransaction();

            Set<Course> courses = new HashSet<>();
            courses.add(new Course("Maths"));
            courses.add(new Course("Computer Science"));

            Student student1 = new Student("Eswar", courses);
            Student student2 = new Student("Joe", courses);
            session.persist(student1);
            session.persist(student2);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error in main", e);
        }
    }
}
