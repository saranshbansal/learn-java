package com.scratchpad;

import java.util.Arrays;
import java.util.List;

public class CreatePeople {

	public static void main(String[] args) {
		List<People> peoples = createPeople();
		List<String> names = (List<String>) peoples.parallelStream().map(p -> p.getName()).map(name -> name.toUpperCase());
		System.out.println(names);
	}


	private static List<People> createPeople() {
		return Arrays.asList(
				new People("Sara", 12, Gender.M.getValue()), new People("Sara1", 13, Gender.F.getValue()),
				new People("Sara1", 56, Gender.M.getValue()), new People("Sara3", 27, Gender.F.getValue()));
	}

}
