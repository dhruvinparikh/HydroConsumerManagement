/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.SQLException;

/**
 *
 * @author imsil
 */
public class DBException extends Exception{
    public DBException(){
        super("Connection unsuccessful");
    }
    public DBException(String strMessage){
        super(strMessage);
    }
    public DBException(SQLException e){
        super(e);
    }
}
