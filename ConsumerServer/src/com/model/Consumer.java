/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author imsil
 */
public class Consumer extends Person implements Comparable<Consumer>,Serializable {

    private long ConsumerID;
    private double billAmount;
    private Date dueDate;

    @Override
    public String toString() {
        DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
        return super.toString() + "Consumer{" + "ConsumerID=" + ConsumerID + ", billAmount=" + billAmount + ", dueDate=" + shortDf.format(dueDate) + '}';
    }

    public Consumer() {
        this(0, 0, null, "", "", "");
    }

    public Consumer(long ConsumerID, double billAmount, Date dueDate, String firstName, String lastName, String city) {
        super(firstName, lastName, city);
        this.ConsumerID = ConsumerID;
        this.billAmount = billAmount;
        this.dueDate = dueDate;
    }

    public Consumer(long ConsumerID, double billAmount, Date dueDate) {
        this.ConsumerID = ConsumerID;
        this.billAmount = billAmount;
        this.dueDate = dueDate;
    }

    /**
     * @return the ConsumerID
     */
    public long getConsumerID() {
        return ConsumerID;
    }

    /**
     * @param ConsumerID the ConsumerID to set
     */
    public void setConsumerID(long ConsumerID) {
        this.ConsumerID = ConsumerID;
    }

    /**
     * @return the billAmount
     */
    public double getBillAmount() {
        return billAmount;
    }

    /**
     * @param billAmount the billAmount to set
     */
    public void setBillAmount(double billAmount) throws ValidBillAmountException {
        if (billAmount < 0) {
            throw new ValidBillAmountException();
        } else {
            this.billAmount = billAmount;
        }
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public int compareTo(Consumer another) {
        return dueDate.compareTo(another.dueDate);
    }

}
