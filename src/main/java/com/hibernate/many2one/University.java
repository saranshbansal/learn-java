package com.hibernate.many2one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UNIVERSITY")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIVERSITY_ID")
    private long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @Builder.Default
    @OneToMany(mappedBy = "university",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    // Helper method to manage bidirectional relationship
    public void addStudent(Student student) {
        students.add(student);
        student.setUniversity(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setUniversity(null);
    }
}
