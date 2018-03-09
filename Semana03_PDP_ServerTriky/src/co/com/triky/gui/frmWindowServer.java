/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triky.gui;

import co.com.triky.thread.ThreadReceiveServer;
import co.com.triky.thread.ThreadSendServer;
import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilmar Duque
 */
public class frmWindowServer extends javax.swing.JFrame {

    private static ServerSocket ssServer;
    private static Socket sConnection;
    private static final int PUERTO = 12345;
    private static frmWindowServer window;

    public frmWindowServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void printButton(String number) {
        try {
            Class cClase = getClass();
            Field fField = cClase.getDeclaredField("btn" + number);
            JButton button = (JButton) fField.get(this);
            button.setBackground(Color.BLUE);
            button.setEnabled(false);
            this.setEnabled(true);
            validarSiHayGanador();
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(frmWindowServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void validarSiHayGanador() {
        validarDiagonalPrincipal();
        validarDiagonalSecundaria();
        validarHorizontal();
        validarVertical();
    }

    private void validarDiagonalPrincipal() {
        Color color = Color.BLUE;
        if (btn1.getBackground() == color && btn5.getBackground() == color && btn9.getBackground() == color) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        }
    }

    private void validarDiagonalSecundaria() {
        Color color = Color.BLUE;
        if (btn3.getBackground() == color && btn5.getBackground() == color && btn7.getBackground() == color) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        }
    }

    private void validarHorizontal() {
        Color color = Color.BLUE;
        if (btn4.getBackground() == color && btn5.getBackground() == color && btn6.getBackground() == color) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        } else if (btn1.getBackground() == color && btn2.getBackground() == color && btn3.getBackground() == color) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        } else if (btn7.getBackground() == color && btn8.getBackground() == color && btn9.getBackground() == color) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        }
    }

    private void validarVertical() {
        Color color = Color.BLUE;
        if ((btn1.getBackground() == color && btn4.getBackground() == color && btn7.getBackground() == color)
                || (btn2.getBackground() == color && btn5.getBackground() == color && btn8.getBackground() == color)
                || (btn3.getBackground() == color && btn6.getBackground() == color && btn9.getBackground() == color)) {
            JOptionPane.showMessageDialog(null, "Cliente ha ganado");
            PreguntarSalida();
        }
    }

    public void CleanButtons() {
        String color = "#F0F0F0";
        Boolean enabled = true;
        this.setEnabled(enabled);
        btn1.setEnabled(enabled);
        btn1.setBackground(Color.decode(color));
        btn2.setEnabled(enabled);
        btn2.setBackground(Color.decode(color));
        btn3.setEnabled(enabled);
        btn3.setBackground(Color.decode(color));
        btn4.setEnabled(enabled);
        btn4.setBackground(Color.decode(color));
        btn5.setEnabled(enabled);
        btn5.setBackground(Color.decode(color));
        btn6.setEnabled(enabled);
        btn6.setBackground(Color.decode(color));
        btn7.setEnabled(enabled);
        btn7.setBackground(Color.decode(color));
        btn8.setEnabled(enabled);
        btn8.setBackground(Color.decode(color));
        btn9.setEnabled(enabled);
        btn9.setBackground(Color.decode(color));
    }

    private void PreguntarSalida() {
        ThreadSendServer tssThread = new ThreadSendServer(sConnection, window);
        int response = JOptionPane.showConfirmDialog(null, "El juego ha terminado. ¿Desea reiniciarlo?",
                "Confirmación", JOptionPane.YES_NO_OPTION);
        if (response == 0) {
            tssThread.run();
            tssThread.sendButton(btn1, "HayGanador");
            CleanButtons();
        } else {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        window = new frmWindowServer();
        window.setVisible(true);
        window.setTitle("Server Triky");

        ExecutorService esService = Executors.newCachedThreadPool();

        try {
            ssServer = new ServerSocket(PUERTO);
            while (true) {
                sConnection = ssServer.accept();
                esService.execute(new ThreadSendServer(sConnection, window)); //Thread for send
                esService.execute(new ThreadReceiveServer(sConnection, window)); //Thread for receive
            }
        } catch (IOException ex) {
            Logger.getLogger(frmWindowServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        esService.shutdown();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    public javax.swing.JButton btn4;
    public javax.swing.JButton btn5;
    public javax.swing.JButton btn6;
    public javax.swing.JButton btn7;
    public javax.swing.JButton btn8;
    public javax.swing.JButton btn9;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}
