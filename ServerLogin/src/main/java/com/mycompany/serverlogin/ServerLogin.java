/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverlogin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LABORATORIO 04
 */
public class ServerLogin {

    public static void main(String[] args) {
        ServerSocket serverSock  = null;
        try{
            serverSock = new ServerSocket(3030);
        }catch(IOException e){
            System.err.println("Error del server socket 's'");
        }
        
        
        while(true){
            
            
            DataInputStream dis = null;
            
            try{
                Socket s1 = serverSock.accept();
                
                dis = new DataInputStream(s1.getInputStream());
                
                
                System.out.println("Se está conectando a algo");
            }catch(IOException e){
                System.err.println("Error con la comunicacion servidor");
            }
            
            if(dis != null){
                
                try {
                    System.out.println(dis.readUTF());
                    dis.close();
                } catch (IOException e) {
                }
                
            }
            
            
            
            
        }
    }
}
