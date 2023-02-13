package com.sparta.firstspring.dtos;

public class StaffDTO {
    private short id;
    private String firstName;
    private String lastName;
    private String address;

    public short getId() {
        return id;
    }

    public void setId(short id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " Address: " + address;
    }

}
