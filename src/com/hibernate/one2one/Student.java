package com.hibernate.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student
{

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SECTION")
    private String section;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Address address;


    public Student()
    {

    }


    public Student(String firstName, String lastName, String section)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getFirstName()
    {
        return firstName;
    }


    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getSection()
    {
        return section;
    }


    public void setSection(String section)
    {
        this.section = section;
    }


    public Address getAddress()
    {
        return address;
    }


    public void setAddress(Address address)
    {
        this.address = address;
    }


    @Override
    public String toString()
    {
        return "Student [id="
            + id + ", firstName=" + firstName + ", lastName="
            + lastName + ", section=" + section + ", address=" + address
            + "]";
    }

}
