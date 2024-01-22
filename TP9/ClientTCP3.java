import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ClientTCP3 <message>");
            return;
        }

        try {
            // Connexion au serveur sur le port 2016
            Socket socket = new Socket("localhost", 2016);

            // Création d'un DataOutputStream pour envoyer des données au serveur
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            // Envoi du message au serveur
            dOut.writeUTF(args[0]);

            // Création d'un DataInputStream pour lire le même message du serveur
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String echoedMsg = dIn.readUTF();

            // Affichage du même message reçu du serveur
            System.out.println("Message reçu du serveur: " + echoedMsg);

            // Fermeture de la socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

