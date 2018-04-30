/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;
import com.model.*;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author imsil
 */
public class CreateTable {

    public static Object[][] getRow(List<Consumer> consumer) {
        if (consumer != null) {
            Collections.sort(consumer);
            Object[][] row = new Object[consumer.size()][6];
            for (int i = 0; i < consumer.size(); i++) {
                int j = 0;
                row[i][j++] = consumer.get(i).getConsumerID();
                row[i][j++] = consumer.get(i).getFirstName();
                row[i][j++] = consumer.get(i).getLastName();
                row[i][j++] = consumer.get(i).getCity();
                row[i][j++] = consumer.get(i).getBillAmount();
                DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
                row[i][j++] = shortDf.format(consumer.get(i).getDueDate());
            }
            return row;
        } else {
            return null;
        }

    }
}