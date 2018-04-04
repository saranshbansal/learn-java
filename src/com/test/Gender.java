package com.test;

public enum Gender {
	M("M"), F("F");
	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
