package com.hibernate.one2one;

import org.hibernate.Session;

import java.util.List;

public class HibernateStandAlone {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Student student = new Student("Sam", "Disilva", "Maths");
		Address address = new Address("10 Silver street", "NYC", "USA");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		student.setAddress(address);
		address.setStudent(student);
		session.save(student);

		List<Student> students = (List<Student>) session.createQuery("from Student ").list();
		for (Student s : students) {
			System.out.println("Details : " + s);
		}

		session.getTransaction().commit();
		session.close();
	}

}
