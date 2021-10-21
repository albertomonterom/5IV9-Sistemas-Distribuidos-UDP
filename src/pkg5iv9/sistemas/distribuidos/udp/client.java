package pkg5iv9.sistemas.distribuidos.udp;

import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author molin
 */
public class client {
    
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {

        
        System.out.println(""
                + "Conectado con el Servidor");
        
        
        System.out.println(""
                + "Esperando...");
        
        
        System.out.println(""
                + "Sí desea salir del chat favor de escribir 'Salir'");
        
        
        System.out.println(""
                + "Por favor ingresa un mensaje: ");
        
        try (BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                
                DatagramSocket client = new DatagramSocket();) {
            
            while (true) {
                InetAddress ipaddress = 
                        InetAddress.getByName(""
                                + "localhost");
                
                byte[] sendData = 
                        new byte[1024];
                
                byte[] receiveData = 
                        new byte[1024];
                
                String sentence = 
                        inFromUser.readLine();
                
                System.out.println(""
                        + "Cliente(usted): " 
                        + sentence);
                
                if (sentence.equals(""
                        + "Salir") || sentence.equals(""
                                + "salir")) {
                    
                    sentence = 
                            "adios";
                    
                    sendData = 
                            sentence.getBytes();

                    DatagramPacket sendPacket = 
                            new DatagramPacket(sendData, sendData.length, ipaddress, 9876);
                    
                    client.send(sendPacket);
                    
                    
                    
                    
                    
                    System.exit(0);
                    
                    break;
                }
                sendData = 
                        sentence.getBytes();
                DatagramPacket sendPacket = 
                        new DatagramPacket(sendData, sendData.length, ipaddress, 9876);
                
                client.send(sendPacket);

                DatagramPacket receivePacket = 
                        new DatagramPacket(receiveData, receiveData.length);
                client.receive(receivePacket);
                
                sentence = new String(receivePacket.getData());
                
                
                System.out.println(""
                        + "Server:" + sentence);
            }
        } catch (SocketException e) {
            
            e.printStackTrace();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
}
