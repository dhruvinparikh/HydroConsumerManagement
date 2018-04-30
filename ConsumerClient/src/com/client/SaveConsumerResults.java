/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;
import com.model.*;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author imsil
 */
public class SaveConsumerResults {

    public static void saveRecord(String strName, Consumer consumer) throws FileNotFoundException, IOException {
        DateFormat shortDf = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String date = shortDf.format(new Date());
        strName += "-" + date + ".txt";

        DataOutputStream outFile = new DataOutputStream(new FileOutputStream(strName, true));
        outFile.writeLong(consumer.getConsumerID());
        outFile.writeChars(consumer.getFirstName());
        outFile.writeChars(consumer.getLastName());
        outFile.writeChars(consumer.getCity());
        outFile.writeDouble(consumer.getBillAmount());
        outFile.writeChars(shortDf.format(consumer.getDueDate()));
        outFile.close();
    }

    public static void saveRecords(String strName, List<Consumer> consumers) throws FileNotFoundException, IOException {
        DateFormat shortDf = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String date = shortDf.format(new Date());
        strName += "-" + date + ".txt";

        DataOutputStream outFile = new DataOutputStream(new FileOutputStream(strName, true));
        for (int i = 0; i < consumers.size(); i++) {
            outFile.writeLong(consumers.get(i).getConsumerID());
            outFile.writeChars(consumers.get(i).getFirstName());
            outFile.writeChars(consumers.get(i).getLastName());
            outFile.writeChars(consumers.get(i).getCity());
            outFile.writeDouble(consumers.get(i).getBillAmount());
            outFile.writeChars(shortDf.format(consumers.get(i).getDueDate()));
        }
        outFile.close();
    }
}
