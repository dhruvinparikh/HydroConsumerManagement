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
import java.net.Socket;

/**
 *
 * @author Dhruvin
 */
public class IOUtil {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static ObjectOutputStream objectOutputStream = null;
    private static ObjectInputStream objectInputStream = null;
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public static DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public static ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public static ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public static BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }
    
    public static void InitStream(Socket socket) throws IOException{
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataInputStream = new DataInputStream(socket.getInputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    
    public static void CloseStream() throws IOException{
        objectOutputStream.close();
        dataOutputStream.close();
        dataInputStream.close();
        objectInputStream.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
