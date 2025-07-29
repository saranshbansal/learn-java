package com.hibernate.one2one;

import org.hibernate.Session;

import java.util.List;

public class HibernateStandAlone {

    public static void main(String[] args) {

        Student student = new Student("Sam", "Disilva", "Maths");
        Address address = new Address("10 Silver street", "NYC", "USA");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        student.setAddress(address);
        address.setStudent(student);
        session.persist(student);

        List<Student> students = session.createQuery("from Student ", Student.class).list();
        for (Student s : students) {
            System.out.println("Details : " + s);
        }

        session.getTransaction().commit();
        session.close();
    }
}
