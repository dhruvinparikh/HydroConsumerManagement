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
public class UnableToSaveException extends Exception {

    public UnableToSaveException() {
        super("Cannot be saved");
    }

    public UnableToSaveException(String string) {
        super(string);
    }
    
}
