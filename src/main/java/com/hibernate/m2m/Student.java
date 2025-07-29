package com.hibernate.m2m;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Entity
@Table(name = "STUDENT")
public class Student {

    private long studentId;
    private String studentName;
    private Set<Course> courses = new HashSet<>(0);

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentName, Set<Course> courses) {
        this.studentName = studentName;
        this.courses = courses;
    }

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    public long getStudentId() {
        return this.studentId;
    }

    @Column(name = "STUDENT_NAME", nullable = false, length = 100)
    public String getStudentName() {
        return this.studentName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE", joinColumns = {@JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    public Set<Course> getCourses() {
        return this.courses;
    }
}
