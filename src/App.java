import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.service.app.microservices.TimeMicroService;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class App  {

public static void main(String[] args) throws IOException {
        // Crear un servidor en el puerto 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Crear un contexto para manejar las solicitudes en la raíz del servidor
        server.createContext("/", new MyHandler());

        // Iniciar el servidor
        server.start();

        System.out.println("Servidor iniciado en el puerto 8080");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Manejar la solicitud y enviar una respuesta simple
            TimeMicroService t = new TimeMicroService();
            String response = t.getTiempo();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

