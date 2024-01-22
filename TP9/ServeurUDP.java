import java.net.*;
import java.io.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1234);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String receivedString = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Reçu du client : " + receivedString);

                // Renvoyer la chaîne au client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = receivedString.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

