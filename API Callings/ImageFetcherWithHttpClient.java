import java.net.http.*;
import java.net.*;
import java.io.*;
import java.nio.file.*;

public class ImageFetcherWithHttpClient {
    public static void main(String[] args) throws Exception {
        String imageUrl = "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg";
        String destinationFile = "downloaded_image.jpg";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(destinationFile)));

        System.out.println("Image saved to: " + response.body());
    }
}
