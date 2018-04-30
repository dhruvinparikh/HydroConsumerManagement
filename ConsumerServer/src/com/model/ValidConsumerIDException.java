/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author imsil
 */
public class ValidConsumerIDException extends Exception {

    public ValidConsumerIDException() {
        super("Consumer ID must be 11 digits");
    }

    public ValidConsumerIDException(String string) {
        super(string);
    }
    
}
