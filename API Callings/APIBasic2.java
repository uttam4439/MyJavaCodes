import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIBasic2{
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://api.thedogapi.com/v1/images/search";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println("Raw JSON: " + json);

        if (json.contains("\"breeds\":") && json.contains("\"name\":\"")) {
            int nameIndex = json.indexOf("\"name\":\"");
            int start = nameIndex + 8;
            int end = json.indexOf("\"", start);
            String name = json.substring(start, end);
            System.out.println("Dog Breed Name: " + name);
        } else {
            System.out.println("No breed name found in this image.");
        }
    }
}
