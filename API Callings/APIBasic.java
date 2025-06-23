import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/* Link for Document Reading about API 
https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html*/ 


public class APIBasic{
    public static void main(String[] args) throws IOException, InterruptedException{
        var url = "https://api.thedogapi.com/v1/images/search";

        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();

        var response =client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}

