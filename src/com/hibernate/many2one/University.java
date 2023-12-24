package com.hibernate.many2one;

import javax.persistence.*;
import java.util.List;

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


	public University() {

	}


	public University(String name, String country) {
		this.name = name;
		this.country = country;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "University [id="
				+ id + ", name=" + name + ", country="
				+ country + "]";
	}

}
