import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;

public class Client1 {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java ClientHTTP <movie>");
                System.exit(1);
            }

            // Replace "YOUR_API_KEY" with the actual API key provided by your instructor
            String apiKey = "c8561dd0";
            String movieTitle = args[0];

            // Construct the URL with the OMDb API endpoint and parameters
            String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieTitle;

            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);

            System.out.println("Executing request " + request.getRequestLine());
            CloseableHttpResponse resp = client.execute(request);

            System.out.println("Response Line: " + resp.getStatusLine());
            System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());

            // Ajouter le code pour récupérer la page envoyée par le serveur
            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
                result.append("\n"); // pour avoir le saut de ligne
            }

            // Afficher la page à l’écran
            String page = result.toString();
            System.out.println("Page récupérée du serveur:\n" + page);

            // Écrire la réponse dans un fichier
            try (FileWriter writer = new FileWriter("response.json")) {
                writer.write(page);
            }

            // Fermer les ressources
            rd.close();
            resp.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

