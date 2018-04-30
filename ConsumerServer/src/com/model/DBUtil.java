/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author imsil
 */
public class DBUtil {

    private static Connection connection;

    private DBUtil() {

    }

    public static Connection getConnection() throws ClassNotFoundException, DBException {
        if (connection != null) {
            return connection;
        } else {
            try {
                //set the db url, username and password
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@dilbert.humber.ca:1521:grok";
                String username = "n01150847";
                String password = "oracle";
                //get and return connection
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            } catch (SQLException ex) {
                throw new DBException(ex);
            }
        }
    }
       

    public static void closeConnection() throws DBException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e);
            } finally {
                connection = null;
            }
        }
    }
}
