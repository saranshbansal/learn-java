package com.hibernate.many2one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            registerStudents(tx, em);
        } catch (Exception e) {
            log.error("Error in main", e);
        } finally {
            HibernateUtil.shutdown();
        }
    }

    private static void registerStudents(EntityTransaction tx, EntityManager em) {
        try {
            tx.begin();

            // Create and save university
            University university = University.builder()
                    .name("CAMBRIDGE")
                    .country("ENGLAND")
                    .build();

            // Create and save students
            Student student1 = Student.builder()
                    .firstName("Sam")
                    .lastName("Disilva")
                    .section("Maths")
                    .university(university)
                    .build();

            Student student2 = Student.builder()
                    .firstName("Joshua")
                    .lastName("Brill")
                    .section("Science")
                    .university(university)
                    .build();

            // Add students to university
            university.addStudent(student1);
            university.addStudent(student2);

            em.persist(university);
            tx.commit();

            // Query and print results
            List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
            students.forEach(student ->
                    log.info("Student: {} {}, University: {}",
                            student.getFirstName(),
                            student.getLastName(),
                            student.getUniversity().getName()));

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            log.error("Transaction failed", e);
        }
    }
}
