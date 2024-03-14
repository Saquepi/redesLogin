/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientelogin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Venta PC
 */
public class SwingLoginClient {
    Client c = new Client();
    
    private JFrame ventana;
    private JPanel panel;
    private JTextField userTxt;
    private JTextField passwordTxt;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton aceptarBtn;

    public SwingLoginClient() {
        ventana = new JFrame("Login");
        panel = new JPanel();
        userTxt = new JTextField();
        passwordTxt = new JTextField();
        userLabel = new JLabel("Usuario:");
        passwordLabel = new JLabel("Contraseña:");
        aceptarBtn = new JButton("Aceptar");
    }
    
    public void iniciar(){
        ventana.setSize(600, 400);
        
        panel.setLayout(null);
        panel.setBackground(Color.black);
        
        userLabel.setBounds(100, 50, 100, 20);
        userLabel.setForeground(Color.white);
        userTxt.setBounds(200, 50, 300, 20);
        passwordLabel.setBounds(100, 150, 100, 20);
        passwordLabel.setForeground(Color.white);
        passwordTxt.setBounds(200, 150, 300, 20);
        aceptarBtn.setBounds(450, 300, 100, 40);
        
        
        aceptarBtn.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                String user = userTxt.getText();
                String pass = passwordTxt.getText();
                String r=c.runClient(user+"#"+pass);
                if(r.equals("1")){
                    JOptionPane.showMessageDialog(null, "Sesion Iniciada");
                }else if(r.equals("2")){
                    JOptionPane.showMessageDialog(null, "Usuario no existe");
                }else if(r.equals("3")){
                    JOptionPane.showMessageDialog(null, "Contraseña equivocada");
                }else if(r.equals("0")){
                    JOptionPane.showMessageDialog(null, "Introduzca una contraseña");
                }else{
                    JOptionPane.showMessageDialog(null, "Error desconocido pero jaló, sesión no iniciada");
                }
            }
            
        });
        
        
        
        panel.add(userLabel);
        panel.add(userTxt);
        panel.add(passwordLabel);
        panel.add(passwordTxt);
        panel.add(aceptarBtn);
        
        ventana.add(panel);
        
        ventana.setDefaultCloseOperation(3);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
}
