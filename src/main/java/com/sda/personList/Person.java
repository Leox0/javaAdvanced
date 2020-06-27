package com.sda.personList;

public class Person {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;


    public Person(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "\nUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                "}";
    }
}

