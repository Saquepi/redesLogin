/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.servidorlogin;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Venta PC
 */
public class ServidorLogin {

    
    
    
    
    
    public static void main(String[] args) {
        ServerThread[] threads = new ServerThread[200000];
        int threadCount = 0;
        
        
        ServerSocket serverSock  = null;
        try{
            serverSock = new ServerSocket(3030);
        }catch(IOException e){
            System.out.println("Error del server socket 's'");
        }
        
        
        while(threadCount<200000){
            Socket s1 = null;
            
            try{
                s1 = serverSock.accept();
                threads[threadCount] = new ServerThread(s1);
                threads[threadCount].start();
                threadCount++;
                
                System.out.println("Hilo Servidor Creado "+threadCount);                               
            }catch(IOException e){
                System.out.println("Error crear Hilo Servidor");
            }
            
        }
        
        System.out.println("maximo de threads creados alcanzados");
            
    }
}

    
