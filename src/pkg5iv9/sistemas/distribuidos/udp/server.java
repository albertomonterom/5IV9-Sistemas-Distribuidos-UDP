/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5iv9.sistemas.distribuidos.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author molin
 */
public class server {
     public static void main(String[] args) throws SocketException, IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket server = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println(""
                + "Iniciando Server");
        System.out.println(""
                + "Esperando...");
        System.out.println(""
                + "Esperando...");
        System.out.println(""
                + "Esperando...");
        System.out.println(""
                + "Server conectado");
     
        
        
        int valor_inicial = 0;
        int i = valor_inicial;

        System.out.println(""
                + "Sí desea salir favor de escribir 'Salir'");
        System.out.println(""
                + "Conectando con Cliente...");
        System.out.println(""
                + "Conectado");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            
            server.receive(receivePacket);
            
            String sentencia = new String(receivePacket.getData());
            
            
            
            
            
            
            System.out.println(""
                    + "Cliente: "
                    
                    + sentencia);
            
            if (i < 1) {

                System.out.println(""
                        + "Favor de ingresar un mensaje: ");
                i = 1;
            }
            int port = receivePacket.getPort();
            
            InetAddress ipaddress = receivePacket.getAddress();
            
            
            
            sentencia = inFromUser.readLine();
            
            
            
            if (sentencia.equals("Salir") || sentencia.equals("salir")) {
                sentencia = ""
                        + "adios";
                
                sendData = sentencia.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipaddress, port);
                
                
                System.out.println(""
                        + "Servidor(usted): " + sentencia);
                server.send(sendPacket);
                
                System.exit(0);
            }
            sendData = sentencia.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipaddress, port);
            System.out.println(""
                    + "Servidor(usted): " + sentencia);
            server.send(sendPacket); 
        }
    }
    
}
