import java.io.*;
import java.net.*;

public class ClientTCP1 {
    public static void main(String[] args) {
        try {
            // Connexion au serveur sur le port 2016
            Socket socket = new Socket("localhost", 2016);

            // Création d'un DataOutputStream pour envoyer des données au serveur
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            // Envoi du message au serveur
            dOut.writeUTF("message test");

            // Fermeture de la socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

