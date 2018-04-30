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
public class NoRecordException extends Exception {

    public NoRecordException() {
        super("No record available");
    }

    public NoRecordException(String string) {
        super(string);
    }
    
}
