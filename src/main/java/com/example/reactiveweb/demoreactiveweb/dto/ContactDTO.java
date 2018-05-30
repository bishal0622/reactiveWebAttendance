package com.example.reactiveweb.demoreactiveweb.dto;

import com.example.reactiveweb.demoreactiveweb.domain.Contact;

public class ContactDTO {

    private String id;
    private String phoneNumber;
    private String address;

    public ContactDTO() {
    }

    public ContactDTO(String id, String phoneNumber, String address) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ContactDTO(Contact contact){
        this(contact.getId(),contact.getPhoneNumber(),contact.getAddress());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

