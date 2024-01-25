import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHttp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java ClientHttp <hostname>");
            System.exit(1);
        }

        String hostname = args[0];

        try {
           
            Socket socket = new Socket(hostname, 80);

       
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            
            out.println("GET / HTTP/1.1");
            out.println("Host: " + hostname);
            out.println("Connection: close");
            out.println();

    
            out.flush();

            
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close the resources
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

