// ClientTCP2.java
import java.io.*;
import java.net.*;

public class ClientTCP2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ClientTCP2 <message>");
            return;
        }

        try {
            // Connexion au serveur sur le port 2016
            Socket socket = new Socket("localhost", 2016);

            // Création d'un DataOutputStream pour envoyer des données au serveur
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            // Envoi du message au serveur
            dOut.writeUTF(args[0]);

            // Fermeture de la socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

