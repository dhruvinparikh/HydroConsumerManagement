/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author imsil
 */
public class Person implements Serializable{

    private String firstName;
    private String lastName;
    private String city;

    public Person(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public Person() {
        this("", "", "");
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) throws ValidNameException {
        if (isValidName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new ValidNameException("Invalid first name");
        }
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) throws ValidNameException {
        if (isValidName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new ValidNameException("Invalid last name");
        }
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) throws ValidNameException {
        if (isValidName(city)) {
            this.city = city;
        } else {
            throw new ValidNameException("Invalid city name");
        }
    }

    public boolean isValidName(String strName) {
        boolean valid = false;
        for (int i = 1; i < strName.length(); i++) {
            if (Character.isAlphabetic(strName.charAt(i)) || strName.charAt(i) == '\0' || strName.charAt(i) == ' ') {
                valid = true;
            }
            else
                valid = false;
            
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + '}';
    }

}
