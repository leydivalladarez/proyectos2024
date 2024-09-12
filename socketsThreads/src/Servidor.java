import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) {
        int port = 5000; // puerto en el que el servidor escuchará conexiones

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nueva conexión de cliente: " + clientSocket.getInetAddress());

                // Crear un nuevo hilo para manejar la conexión del cliente
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Mensaje del cliente: " + inputLine);
                out.println("Echo: " + inputLine); // Enviar una respuesta al cliente
            }
        } catch (IOException e) {
            System.err.println("Error manejando la conexión del cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error cerrando el socket del cliente: " + e.getMessage());
            }
        }
    }
}