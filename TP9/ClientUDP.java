import java.net.*;
import java.io.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            InetAddress serverAddr = InetAddress.getLocalHost();
            System.out.println("Adresse du serveur=" + serverAddr.getHostAddress());

            String messageToSend = "TCP OKKKKKK";
            byte[] sendData = messageToSend.getBytes();

            DatagramSocket clientSocket = new DatagramSocket();

            // Envoi de la chaîne au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddr, 1234);
            clientSocket.send(sendPacket);

            // Attente de la réponse du serveur
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String receivedString = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Reçu du ServeurTCP : " + receivedString);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

