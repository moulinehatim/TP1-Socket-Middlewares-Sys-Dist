package Q1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Side");
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server en action\n");

        System.out.println("Attente de connexion avec client");
        Socket s = ss.accept(); 
        System.out.println("Connexion etablie avec client\n");

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        System.out.println("Attente du nombre");
        int nb = is.read(); // attente d’un octet
        System.out.println("Nombre recu : "+nb+"\n");
        int rep = nb * 2;
        System.out.println("Nombre apres traitement : "+rep+"\n");
        os.write(rep);
        System.out.println("Envoi fait");

        ss.close();
    }
}
