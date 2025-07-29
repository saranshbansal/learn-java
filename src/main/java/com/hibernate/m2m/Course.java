package com.hibernate.m2m;

import jakarta.persistence.*;
import lombok.Setter;

@Setter
@Entity
@Table(name = "COURSE")
public class Course {
    private long courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    public long getCourseId() {
        return this.courseId;
    }

    @Column(name = "COURSE_NAME", nullable = false)
    public String getCourseName() {
        return this.courseName;
    }
}
