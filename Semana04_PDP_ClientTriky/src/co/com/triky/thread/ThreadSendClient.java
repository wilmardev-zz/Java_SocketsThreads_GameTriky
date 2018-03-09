/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triky.thread;

import co.com.gui.triky.frmWindowClient;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Wilmar Duque
 */
public final class ThreadSendClient implements Runnable {

    private final Socket sConnection;
    private final frmWindowClient window;
    private DataOutputStream dosOutput;
    private String msg;

    public ThreadSendClient(Socket sConnection, frmWindowClient window) {
        this.sConnection = sConnection;
        this.window = window;

        for (int i = 1; i < 10; i++) {
            Class cClass;
            try {
                cClass = Class.forName("co.com.gui.triky.frmWindowClient");
                Field fField = cClass.getDeclaredField("btn" + i);
                JButton jButton = (JButton) fField.get(window);
                sendButton(jButton, String.valueOf(i));
            } catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(ThreadSendClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sendButton(final JButton jButton, final String number) {
        
        if (number.equals("HayGanador")) {
            try {
                dosOutput.writeUTF(number);
            } catch (IOException ex) {
                Logger.getLogger(ThreadSendClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dosOutput.writeUTF(number);
                    jButton.setBackground(Color.BLUE);
                    jButton.setEnabled(false);
                    window.setEnabled(false);
                } catch (IOException ex) {
                    Logger.getLogger(ThreadSendClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void run() {
        try {
            dosOutput = new DataOutputStream(sConnection.getOutputStream());
            dosOutput.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThreadSendClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
