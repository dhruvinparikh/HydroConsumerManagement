/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author imsil
 */
public class Server {

    ServerSocket serverSocket = null;
    boolean ServerOn = true;
    static int port = 8000;
    int client=0;
    public Server() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Could not create server socket on port 8000. Quitting.");
            System.exit(-1);
        }

        System.out.println("Server started on port " + port + " at " + new Date() + ".");

        while (ServerOn) {
            try {
                Socket socket = serverSocket.accept();
                client++;
                new Thread(new HandleAClient(socket, ServerOn,client)).start();
            } catch (IOException ex) {
                System.out.println("Exception found on accept. Ignoring. Stack Trace :");
                ex.printStackTrace();
            }
        }
        try {
            serverSocket.close();
            System.out.println("Server Stopped");
        } catch (IOException ex) {
            System.out.println("Error found stopping server socket");
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
