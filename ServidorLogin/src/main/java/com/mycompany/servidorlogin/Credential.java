/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servidorlogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Venta PC
 */
public class Credential {
    String[] creds;
    String response = "0"; //0=error de dato total - 1=true - 2=UsuarioNoExiste - 3=Contraseña Incorrecta
    
    public void start(){
        try{
            File f = new File("Credenciales.txt");
            Scanner  scan = new Scanner(f);
            String s = scan.nextLine();
            
            creds = s.split("#");
        }catch(FileNotFoundException e){
            System.out.println("Error archivo");
        }     
    }
    
    
    public void compare(String s){
        String[] tempCreds = s.split("#");
        
        if(tempCreds.length == creds.length && creds.length == 2){
            if(tempCreds[0].equals(creds[0]) && tempCreds[1].equals(creds[1])){
                response = "1";
            }else{
                if(tempCreds[0].equals(creds[0])){
                    response ="3";
                }else{
                    response ="2";
                }
            }
            
            
        }else{
            response="0";
        }
        
    }
    
    
    public String getResponse(){
        return response;
    }
}
