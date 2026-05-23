package org.example.booter.entity;

import jakarta.persistence.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUEST_ID")
    private Integer id;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Guest() {

    }
    public Guest(String lastName, String firstName, String email, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = email;
        this.phoneNumber = phone;
    }

    public static Guest convertToGuest(String args) {
        Pattern p = Pattern.compile("lastName='(.*?)'.*firstName='(.*?)'.*emailAddress='(.*?)'.*phoneNumber='(.*?)'");
        Matcher m = p.matcher(args);
        Guest guest = null;
        if (m.find()) {
            String lastName = m.group(1);
            String firstName = m.group(2);
            String email = m.group(3);
            String phone = m.group(4);
            guest = new Guest(lastName, firstName, email, phone);
        }
        return guest;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
