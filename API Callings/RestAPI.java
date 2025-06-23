import com.sun.net.httpserver.HttpServer; //HTTP server that can listen to requests and send responses.
import com.sun.net.httpserver.HttpExchange; //HTTP request received and a response to be generated in one exchange.
import com.sun.net.httpserver.HttpHandler; //Interface that you implement to define how a specific endpoint behaves.

import java.io.IOException;
import java.io.OutputStream; // send data back to the client (e.g., the response body).
import java.net.InetSocketAddress; //define the host and port the server should listen on.

public class RestAPI{
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0); 
        //Creates the HTTP server.  // Server listens on port 8000 of localhost  // Port can be changed

        //0: Indicates default backlog size for incoming connections.  (Use system default backlog size)

/*      The backlog is the maximum number of incoming connection requests that can be queued while your server is busy handling other requests.

        Think of it like a waiting room size.

        If the server is busy and more requests are coming in,
        These new connections will be queued in the backlog,
        Once the server is free, it will handle them.  */ 

        server.createContext("/I am Creating a RestAPI", new HelloHandler()); // sets up an endpoint at path what you have given 
        
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8000");
    }

    // Define how to handle /hello
    static class HelloHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, REST!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}