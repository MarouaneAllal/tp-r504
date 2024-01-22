import java.io.*;
import java.net.*;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try {
            // Création d'un serveur socket sur le port 2016
            ServerSocket socketserver = new ServerSocket(2016);
            System.out.println("Serveur en attente");

            // Boucle infinie pour rester actif
            while (true) {
                // Attente de la connexion d'un client
                Socket socket = socketserver.accept();
                System.out.println("Connection d'un client");

                // Création d'un DataInputStream pour lire les données du client
                DataInputStream dIn = new DataInputStream(socket.getInputStream());

                // Lecture du message du client
                String msg = dIn.readUTF();
                System.out.println("Message reçu: " + msg);

                // Création d'un DataOutputStream pour envoyer le même message au client
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                dOut.writeUTF(msg);

                // Fermeture de la socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

