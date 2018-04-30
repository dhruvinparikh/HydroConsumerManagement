/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;

import com.model.*;
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
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author imsil
 */
public class HandleAClient implements Runnable {

    private Socket socket;
    private boolean ServerOn;
    private int client;
    private boolean m_bRunThread = true;

    public HandleAClient(Socket socket, boolean ServerOn, int client) {
        this.socket = socket;
        this.ServerOn = ServerOn;
        this.client = client;
    }

    @Override
    public void run() {
        // Declare data input and output streams
        DataInputStream inputDataFromClient = null;
        DataOutputStream outputDataToClient = null;
        //Declare object input and output streams
        ObjectInputStream inputObjectFromClient = null;
        ObjectOutputStream outputObjectToClient = null;
        //Printsream
        PrintStream printStream = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        int c = 0;
        long id = 0;
        String strName = "";
        DateFormat df = null;
        System.out.println("Client no. " + client + " connected.");
        System.out.println("Accepted Client Address - "
                + socket.getInetAddress().getHostAddress());

        try {
            while (m_bRunThread) {
                // Create data input and output streams
                inputDataFromClient = new DataInputStream(socket.getInputStream());
                outputDataToClient = new DataOutputStream(socket.getOutputStream());

                //Create object input and output streams    
                inputObjectFromClient = new ObjectInputStream(socket.getInputStream());
                outputObjectToClient = new ObjectOutputStream(socket.getOutputStream());
                //PrintStream
                printStream = new PrintStream(socket.getOutputStream());
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                int clientCommand = inputDataFromClient.readInt();
                System.out.println("Client No. " + client + " Says : " + clientCommand);
                if (!ServerOn) {
                    System.out.println("Server has already stopped");
                    m_bRunThread = false;
                }

                switch (clientCommand) {
                    case 1:
                        Consumer consumer = new Consumer();
                        consumer = (Consumer) inputObjectFromClient.readObject();
                        try {
                            ConsumerDB.add(consumer);
                            printStream.println("Record stored succesfully");
                        } catch (DBException ex) {
                            printStream.println(ex);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        outputObjectToClient.writeObject(ConsumerDB.getBillAmount(inputDataFromClient.readDouble(), clientCommand - 1));
                        outputObjectToClient.flush();
                        break;
                    case 7:
                    case 8:
                        df = new SimpleDateFormat("dd/MM/yy");
                        outputObjectToClient.writeObject(ConsumerDB.getDueDate(df.parse(br.readLine().trim()), clientCommand - 6));
                        outputObjectToClient.flush();
                        break;
                    case 9:
                        id = inputDataFromClient.readLong();
                        outputObjectToClient.writeObject(ConsumerDB.get(id));
                        outputObjectToClient.flush();
                        break;
                    case 10:
                        outputObjectToClient.writeObject(ConsumerDB.getFirstName(br.readLine().trim()));
                        outputObjectToClient.flush();
                        break;
                    case 11:
                        outputObjectToClient.writeObject(ConsumerDB.getLastName(br.readLine().trim()));
                        outputObjectToClient.flush();
                        break;
                    case 12:
                        outputObjectToClient.writeObject(ConsumerDB.getCity(br.readLine().trim()));
                        outputObjectToClient.flush();
                        break;
                    case 13:
                        c = ConsumerDB.delete(inputDataFromClient.readLong());
                        outputDataToClient.writeInt(c);
                        outputObjectToClient.writeObject(ConsumerDB.getAll());
                        outputObjectToClient.flush();
                        break;
                    case 14:
                    case 15:
                        df = new SimpleDateFormat("dd/MM/yy");
                        c = ConsumerDB.deleteDueDate(df.parse(br.readLine().trim()), clientCommand - 13);
                        outputDataToClient.writeInt(c);
                        outputObjectToClient.writeObject(ConsumerDB.getAll());
                        outputObjectToClient.flush();
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        c = ConsumerDB.deleteBillAmount(inputDataFromClient.readDouble(), clientCommand - 15);
                        outputDataToClient.writeInt(c);
                        outputObjectToClient.writeObject(ConsumerDB.getAll());
                        outputObjectToClient.flush();
                        break;
                    case 21:
                        c = ConsumerDB.deleteCity(br.readLine().trim());
                        outputDataToClient.writeInt(c);
                        outputObjectToClient.writeObject(ConsumerDB.getAll());
                        outputObjectToClient.flush();
                        break;
                    case 22:
                        outputObjectToClient.writeObject(ConsumerDB.getAll());
                        outputObjectToClient.flush();
                        break;
                    case 23:
                        strName = br.readLine().trim();
                        ConsumerDB.updateFirstName(strName, id);
                        outputObjectToClient.writeObject(ConsumerDB.get(id));
                        outputObjectToClient.flush();
                        break;
                    case 24:
                        strName = br.readLine().trim();
                        ConsumerDB.updateLastName(strName, id);
                        outputObjectToClient.writeObject(ConsumerDB.get(id));
                        outputObjectToClient.flush();
                        break;
                    case 25:
                        strName = br.readLine().trim();
                        ConsumerDB.updateCity(strName, id);
                        outputObjectToClient.writeObject(ConsumerDB.get(id));
                        outputObjectToClient.flush();
                        break;
                    default:
                        System.out.println("Command unrecognisable from client");
                }
                DBUtil.closeConnection();
            }

        } catch (ClassNotFoundException | ParseException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println("Client no. " + client + " disconnected.");
        } catch (DBException ex) {
        } catch (ValidBillAmountException ex) {
        } catch (ValidNameException ex) {
        }
    }

    public HandleAClient() {
        super();
    }
}
