package com.example.reactiveweb.demoreactiveweb.dto;

import com.example.reactiveweb.demoreactiveweb.domain.Contact;
import com.example.reactiveweb.demoreactiveweb.domain.Designation;
import com.example.reactiveweb.demoreactiveweb.domain.User;

public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Contact contact;
    private Designation designation;

    public UserDTO() {
    }

    public UserDTO(String id, String firstName, String lastName, Contact contact, Designation designation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.designation = designation;
    }

    public UserDTO(User user){
        this(user.getId(),user.getFirstName(),user.getLastName(),user.getContact(),user.getDesignation());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                ", designation=" + designation +
                '}';
    }
}
