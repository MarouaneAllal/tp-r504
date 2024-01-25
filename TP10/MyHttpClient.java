public class MyHttpClient {
    public static void main(String[] args) {
        if (args.length > 0) {
            String url = args[0];
            // Utilisez l'URL dans votre programme
            System.out.println("URL du serveur : " + url);
        } else {
            System.out.println("Veuillez fournir l'URL du serveur en argument.");
        }
    }
}

