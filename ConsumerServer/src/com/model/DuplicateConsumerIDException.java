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
public class DuplicateConsumerIDException extends Exception{
    
    public DuplicateConsumerIDException(){
        super("Consumer ID has to be unique");
    }
    
    public DuplicateConsumerIDException(String strMessage){
        super(strMessage);
    }
}
