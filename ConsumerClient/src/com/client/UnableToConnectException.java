/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

/**
 *
 * @author Dhruvin
 */
public class UnableToConnectException extends Exception{

    public UnableToConnectException() {
        super("Socket Exception");
    }

    public UnableToConnectException(String string) {
        super(string);
    }
    
}
