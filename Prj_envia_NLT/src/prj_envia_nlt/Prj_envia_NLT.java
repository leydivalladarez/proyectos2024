/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj_envia_nlt;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Prj_envia_NLT {

    public static void main(String args[]) {
        try {
            DatagramSocket MiSocket = new DatagramSocket();
            byte[] buffer = new byte[15];
            String Mensaje = "Hola soy Nestor desde java";
            buffer = Mensaje.getBytes();
            DatagramPacket Paquete = new DatagramPacket(buffer, Mensaje.length(), InetAddress.getByName("localhost"), 1400);
            MiSocket.send(Paquete);
            MiSocket.close();
        } catch (Exception exc) {
            System.out.println("Error");
        }//try
    }
}
