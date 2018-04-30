/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author imsil
 */
public class client {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        
        
        frame.addWindowListener(new WindowListener(){
                @Override
                public void windowClosing(WindowEvent we){
                    try {
                        ClientUtil.closeSocket();
                    } catch (UnableToConnectException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } 
                }

            @Override
            public void windowOpened(WindowEvent we) {
                    try {
                        ClientUtil.getSocket();
                    } catch (UnableToConnectException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                        System.exit(0);
                    }
            }

            @Override
            public void windowClosed(WindowEvent we) {
                    
            }

            @Override
            public void windowIconified(WindowEvent we) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                
            }

            @Override
            public void windowActivated(WindowEvent we) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                
            }

        });
        
        
        frame.setTitle("Hydro Consumer Data Management");
        frame.pack();
        frame.setVisible(true);frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
