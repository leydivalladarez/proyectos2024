package consumoapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ConsumoAPI {

    public static void main(String[] args) {
        // URL https://jsonplaceholder.typicode.com/users/?id=3
        
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/users/?id=7");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            //Peticion es correcta
            int resposeCode = conn.getResponseCode();
            if(resposeCode != 200){
                throw new RuntimeException("Ocurrio un error" + resposeCode);
                
            }else{
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                
                //Llenar los datos
                while(scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                //Mostrar los datos obtenidos de la URL en la consola
                System.out.print(informationString);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
}

}