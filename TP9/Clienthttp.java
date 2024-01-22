import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clienthttp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Clienthttp <hostname>");
            System.exit(1);
        }

        String hostname = args[0];
        int port = 80;

        try {
            // Ouvrir le socket
            Socket socket = new Socket(hostname, port);

            // Envoyer la requête HTTP GET
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("GET / HTTP/1.1");
            out.println("Host: " + hostname);
            out.println("Connection: close");
            out.println();
            out.flush();

            // Lire la réponse du serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Fermer les flux et le socket
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

