package com.hibernate.many2one;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UNIVERSITY")
public class University {

	@Id
	@GeneratedValue
	@Column(name = "UNIVERSITY_ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COUNTRY")
	private String country;

	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
	private List<Student> students;

	public University(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
