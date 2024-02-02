import java.io.InputStream;
import java.io.InputStreamReader;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;

public class Client2 {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java Client2 <movie-title>");
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
            InputStream contentStream = resp.getEntity().getContent();
            InputStreamReader isr = new InputStreamReader(contentStream);

            // Utiliser le parser JSON pour lire le flux directement
            JsonObject jsonObject = Json.createReader(isr).readObject();

            // Afficher la structure JSON
            System.out.println("JSON Object:\n" + jsonObject.toString());

            // Fermer les ressources
            isr.close();
            resp.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

