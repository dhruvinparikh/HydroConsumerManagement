/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 *
 * @author Dhruvin
 */
public class IOUtility {

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static ObjectOutputStream objectOutputStream = null;
    private static ObjectInputStream objectInputStream = null;
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    private static PrintStream printStream = null;

    public static DataOutputStream getDataOutputStream() throws UnableToConnectException, IOException {
        dataOutputStream = new DataOutputStream(ClientUtil.getSocket().getOutputStream());
        return dataOutputStream;
    }

    public static DataInputStream getDataInputStream() throws UnableToConnectException, IOException {
        dataInputStream = new DataInputStream(ClientUtil.getSocket().getInputStream());
        return dataInputStream;
    }

    public static ObjectOutputStream getObjectOutputStream() throws UnableToConnectException, IOException {
        objectOutputStream = new ObjectOutputStream(ClientUtil.getSocket().getOutputStream());
        return objectOutputStream;
    }

    public static ObjectInputStream getObjectInputStream() throws UnableToConnectException, IOException {
        objectInputStream = new ObjectInputStream(ClientUtil.getSocket().getInputStream());
        return objectInputStream;
    }

    public static BufferedReader getBufferedReader() throws UnableToConnectException, IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(ClientUtil.getSocket().getInputStream()));
        return bufferedReader;
    }
    
    public static BufferedWriter getBufferedWriter() throws UnableToConnectException, IOException {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(ClientUtil.getSocket().getOutputStream()));
        return bufferedWriter;
    }
    
    public static PrintStream getPrintStream() throws UnableToConnectException, IOException {
        printStream = new PrintStream(ClientUtil.getSocket().getOutputStream());
        return printStream;
    }
}
