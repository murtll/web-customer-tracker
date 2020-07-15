package com.murtll.springdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.murtll.springdemo.utils.Utils;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    @Size(min = 1, max = 15, message = "length must be between 1 and 15")
    private String firstName;
    @Column(name = "last_name")
    @Size(min = 1, max = 15, message = "length must be between 1 and 15")
    private String lastName;
    @Column(name = "email")
    @Pattern(regexp = "[\\w]{1,15}@[\\w]{1,15}+\\.[\\w]{1,5}", message = "not correct email")
    private String email;

    public Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        firstName = Utils.capitalize(firstName);

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.trim();
        lastName = Utils.capitalize(lastName);

        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }
}
