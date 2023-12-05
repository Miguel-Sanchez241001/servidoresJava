import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App  {

   public static void main(String[] args) throws IOException {
        // Crea un servidor socket que escuche en el puerto 8080
        ServerSocket servidor = new ServerSocket(8080);



        
        // Espera a que se conecte un cliente
        Socket cliente = servidor.accept();

        // Lee la solicitud del cliente
        byte[] datos = new byte[1024];
        cliente.getInputStream().read(datos);

        // Escribe una respuesta al cliente
        cliente.getOutputStream().write("Hola, mundo!".getBytes());
        
        // Cierra la conexión con el cliente
        cliente.close();

        // Cierra el servidor socket
        servidor.close();
    }
}

