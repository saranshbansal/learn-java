package com.oops.learn;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/*
 * http://cdncontribute.geeksforgeeks.org/wp-content/uploads/Aggregation_1.png
 * It is a special form of Association where:
 * 	It represents Has-A relationship.
 * 	It is a unidirectional association i.e. a one way relationship. For example, department can have students but vice versa is not possible and thus unidirectional in nature.
 * In Aggregation, both the entries can survive individually which means ending one entity will not effect the other entity
 */

//student class
class Student {
	String name;
	int id;
	String dept;


	Student(String name, int id, String dept) {
		this.name = name;
		this.id = id;
		this.dept = dept;
	}
}

/*
 * Department class contains list of student Objects. It is associated with
 * student class through its Object(s).
 */
class Department {

	String name;
	@Getter
	private List<Student> students;


	Department(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}
}


/*
 * Institute class contains list of Department Objects. It is associated with
 * Department class through its Object(s).
 */
class Institute {

	String instituteName;
	private List<Department> departments;


	Institute(String instituteName, List<Department> departments) {
		this.instituteName = instituteName;
		this.departments = departments;
	}


	// count total students of all departments
	// in a given institute
	public int getTotalStudentsInInstitute() {
		return departments.stream()
				.map(Department::getStudents)
				.mapToInt(List::size)
				.sum();
	}
}


// main method
public class Aggregation {
	public static void main(String[] args) {
		Student s1 = new Student("Mia", 1, "CSE");
		Student s2 = new Student("Priya", 2, "CSE");
		Student s3 = new Student("John", 1, "EE");
		Student s4 = new Student("Rahul", 2, "EE");

		// making a List of
		// CSE Students.
		List<Student> cseStudents = new ArrayList<>();
		cseStudents.add(s1);
		cseStudents.add(s2);

		// making a List of
		// EE Students
		List<Student> eeStudents = new ArrayList<>();
		eeStudents.add(s3);
		eeStudents.add(s4);

		Department cse = new Department("CSE", cseStudents);
		Department ee = new Department("EE", eeStudents);

		List<Department> departments = new ArrayList<>();
		departments.add(cse);
		departments.add(ee);

		// creating an instance of Institute.
		Institute institute = new Institute("BITS", departments);

		System.out.print("Total students in institute: ");
		System.out.print(institute.getTotalStudentsInInstitute());
	}
}
