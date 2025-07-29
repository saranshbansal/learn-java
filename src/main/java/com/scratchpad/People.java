package com.scratchpad;

public class People {
    String name;
    Integer age;
    String gender;


    /**
     * @param name
     * @param age
     * @param gender
     */
    public People(String name, Integer age, String gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }


    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }


    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }


    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

}
