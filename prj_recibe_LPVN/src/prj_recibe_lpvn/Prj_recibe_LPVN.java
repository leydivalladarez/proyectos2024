/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj_recibe_lpvn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Prj_recibe_LPVN {

    public static void main(String args[]) {
        try {
            DatagramSocket MiSocket = new DatagramSocket(1400);

            byte[] buffer = new byte[15];
            DatagramPacket Paquete = new DatagramPacket(buffer, buffer.length);
            MiSocket.receive(Paquete);
            System.out.println(new String(Paquete.getData()));
            MiSocket.close();
        } catch (Exception e) {
            System.out.println("Error");
        }//try }//main
    }
}
