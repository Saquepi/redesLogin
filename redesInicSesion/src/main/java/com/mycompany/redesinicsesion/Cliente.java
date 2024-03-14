/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesinicsesion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author LABORATORIO 04
 */
public class Cliente {
    
    
    public void runCliente(String s){
        
        Socket socket1 = null;
        
        try{
            socket1 = new Socket("127.0.0.1",3030);
        }catch(IOException e){
        System.err.println("Error al crear 's1' cliente");
        }
        
        
        while(true){
            
            
            
            
            
                
            
            
            
            
            
            
        }
        
    }
    
    
    
    
    
}
