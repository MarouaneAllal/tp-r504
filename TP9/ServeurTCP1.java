import java.io.*;
import java.net.*;

public class ServeurTCP1 {
    public static void main(String[] args) {
        try {
            // Création d'un serveur socket sur le port 2016
            ServerSocket socketserver = new ServerSocket(2016);
            System.out.println("Serveur en attente");

            // Attente de la connexion d'un client
            Socket socket = socketserver.accept();
            System.out.println("Connection d'un client");

            // Création d'un DataInputStream pour lire les données du client
            DataInputStream dIn = new DataInputStream(socket.getInputStream());

            // Lecture et affichage du message du client
            System.out.println("Message: " + dIn.readUTF());

            // Fermeture des sockets
            socket.close();
            socketserver.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

