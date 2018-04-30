/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imsil
 */
public class ConsumerDB {

    public static List<Consumer> getAll() throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        String sql = "SELECT * FROM CONSUMER ORDER BY DUEDATE";
        List<Consumer> consumers = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> get(Long consumerID) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CONSUMER WHERE CONSUMERID = ?";
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, consumerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
                return consumers;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> getFirstName(String firstName) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CONSUMER WHERE FIRSTNAME = '" + firstName.toUpperCase() + "'";
            Connection connection = DBUtil.getConnection();
            Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> getCity(String city) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CONSUMER WHERE CITY = '" + city.toUpperCase() + "'";
            Connection connection = DBUtil.getConnection();
            Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> getLastName(String lastName) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CONSUMER WHERE LASTNAME = '" + lastName.toUpperCase() + "'";
            Connection connection = DBUtil.getConnection();
            Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> getBillAmount(Double billAmount, int k) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "";
            switch (k) {
                case 1:
                    sql = "SELECT * FROM CONSUMER WHERE BILLAMOUNT > ?";
                    break;
                case 2:
                    sql = "SELECT * FROM CONSUMER WHERE BILLAMOUNT <= ?";
                    break;
                case 3:
                    sql = "SELECT * FROM CONSUMER WHERE BILLAMOUNT >= ?";
                    break;
                case 4:
                    sql = "SELECT * FROM CONSUMER WHERE BILLAMOUNT < ?";
                    break;
                case 5:
                    sql = "SELECT * FROM CONSUMER WHERE BILLAMOUNT = ?";
            }
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, billAmount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static List<Consumer> getDueDate(java.util.Date dateUtil, int k) throws DBException, ClassNotFoundException, ValidBillAmountException, ValidNameException {
        List<Consumer> consumers = new ArrayList<>();
        try {
            String sql = "";
            switch (k) {
                case 1:
                    sql = "SELECT * FROM CONSUMER WHERE DUEDATE >= ?";
                    break;
                case 2:
                    sql = "SELECT * FROM CONSUMER WHERE DUEDATE < ?";
                    break;
            }
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            java.sql.Date date = new java.sql.Date(dateUtil.getYear(), dateUtil.getMonth(), dateUtil.getDate());
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consumer c = new Consumer();
                c.setConsumerID(rs.getLong(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setBillAmount(rs.getDouble(5));
                c.setDueDate(rs.getDate(6));
                consumers.add(c);
            }
            return consumers;
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void add(Consumer consumer) throws DBException, ClassNotFoundException, ParseException {
        String sql = "INSERT INTO CONSUMER(CONSUMERID,FIRSTNAME,LASTNAME,CITY,BILLAMOUNT,DUEDATE) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, consumer.getConsumerID());
            ps.setString(2, consumer.getFirstName().toUpperCase());
            ps.setString(3, consumer.getLastName().toUpperCase());
            ps.setString(4, consumer.getCity().toUpperCase());
            ps.setDouble(5, consumer.getBillAmount());
            DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            java.util.Date dateUtil = df.parse(shortDf.format(consumer.getDueDate()));
            java.sql.Date date = new java.sql.Date(dateUtil.getYear(), dateUtil.getMonth(), dateUtil.getDate());
            ps.setDate(6, date);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void update(Consumer consumer) throws DBException, ClassNotFoundException, ParseException {
        String sql = "UPDATE CONSUMER SET "
                + "FIRSTNAME = ?, "
                + "LASTNAME = ?, "
                + "CITY = ?, "
                + "BILLAMOUNT = ?, "
                + "DUEDATE = ?,"
                + "WHERE CONSUMERID = ?";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, consumer.getFirstName());
            ps.setString(2, consumer.getLastName());
            ps.setString(3, consumer.getCity());
            ps.setDouble(4, consumer.getBillAmount());
            DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            java.util.Date dateUtil = df.parse(shortDf.format(consumer.getDueDate()));
            java.sql.Date date = new java.sql.Date(dateUtil.getYear(), dateUtil.getMonth(), dateUtil.getDate());
            ps.setDate(5, date);
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static int delete(long consumerID) throws DBException, ClassNotFoundException {
        String sql = "DELETE FROM CONSUMER "
                + "WHERE CONSUMERID = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, consumerID);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static int deleteCity(String city) throws DBException, ClassNotFoundException {
        String sql = "DELETE FROM CONSUMER "
                + "WHERE CITY = '"+city.toUpperCase()+"'";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }
    
    public static int deleteDueDate(java.util.Date dateUtil, int k) throws DBException, ClassNotFoundException {
        String sql = "";

        switch (k) {
            case 1:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE DUEDATE < ?";
                break;
            case 2:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE DUEDATE >= ?";
                break;
        }
        Connection connection = DBUtil.getConnection();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        java.sql.Date date = new java.sql.Date(dateUtil.getYear(), dateUtil.getMonth(), dateUtil.getDate());
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, date);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static int deleteBillAmount(Double billAmount, int k) throws DBException, ClassNotFoundException {
        String sql = "";

        switch (k) {
            case 1:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE BILLAMOUNT > ?";
                break;
            case 2:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE BILLAMOUNT < ?";
                break;
            case 3:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE BILLAMOUNT >= ?";
                break;
            case 4:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE BILLAMOUNT <= ?";
                break;
            case 5:
                sql = "DELETE FROM CONSUMER "
                        + "WHERE BILLAMOUNT = ?";
                break;
        }
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, billAmount);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void updateFirstName(String firstName, long consumerID) throws DBException, ClassNotFoundException, ParseException {
        String sql = "UPDATE CONSUMER SET "
                + "FIRSTNAME = '" + firstName.toUpperCase() + "'"
                + "WHERE CONSUMERID = ?";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, consumerID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void updateLastName(String lastName, long consumerID) throws DBException, ClassNotFoundException, ParseException {
        String sql = "UPDATE CONSUMER SET "
                + "LASTNAME = '" + lastName.toUpperCase() + "'"
                + "WHERE CONSUMERID = ?";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, consumerID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

    public static void updateCity(String city, long consumerID) throws DBException, ClassNotFoundException, ParseException {
        String sql = "UPDATE CONSUMER SET "
                + "CITY = '" + city.toUpperCase() + "'"
                + "WHERE CONSUMERID = ?";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, consumerID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DBException(ex);
        }
    }
}
