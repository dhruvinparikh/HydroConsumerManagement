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
public class ValidBillAmountException extends Exception{

    public ValidBillAmountException() {
    super("Bill Amount should be non negative");
    }

    public ValidBillAmountException(String string) {
        super(string);
    }
    
}
