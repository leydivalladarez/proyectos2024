
import java.net.*;
import java.io.*;

public class cliente {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            System.out.println("Conectado al servidor. Escribe tu mensaje:");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Respuesta del servidor: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se conoce el host: " + hostname);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de E/S en la conexión al host " + hostname);
            e.printStackTrace();
        }
    }
}
