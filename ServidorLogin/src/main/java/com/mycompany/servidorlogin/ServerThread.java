/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servidorlogin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Venta PC
 */
public class ServerThread extends Thread{
    
    Socket s1;
    Credential c = new Credential();

    public ServerThread(Socket s1) {
        this.s1 = s1;
    }
    
    
    
    @Override
    public void run(){
        c.start();
        
        DataInputStream dis = null;
        DataOutputStream dos = null;
        
        try{
            //receives message and sends to compare
            dis = new DataInputStream(s1.getInputStream());
            c.compare(dis.readUTF());
            
            //gets response var from class Credential and sends it
            dos = new DataOutputStream(s1.getOutputStream());
            dos.writeUTF(c.getResponse());
            
            
            //closes data streams
            dis.close();
            dos.close();
  
        }catch(IOException e){
        }
        
        if(s1 != null){
            //closing the client
            try{
                s1.close();
            }catch(IOException e){
                
            }
        }
        
        
    }
}
