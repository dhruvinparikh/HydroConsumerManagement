/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Dhruvin
 */
public class ClientUtil {

    private static Socket socket;

    public ClientUtil() {
    }

    public static Socket getSocket() throws UnableToConnectException {
        if (socket != null) {
            return socket;
        } else {
            try {
                String host = "localhost";
                int port = 8000;
                socket = new Socket(host, port);
                return socket;
            } catch (IOException ex) {
                throw new UnableToConnectException();
            }
        }
    }

    public static void closeSocket() throws UnableToConnectException {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ex) {
                throw new UnableToConnectException("unable to close");
            } finally {
                socket = null;
            }
        }
    }

    
}
