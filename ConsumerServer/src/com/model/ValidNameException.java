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
public class ValidNameException extends Exception{

    public ValidNameException() {
        super("Only alphabets allowed in name");
    }

    public ValidNameException(String string) {
        super(string);
    }
    
}
