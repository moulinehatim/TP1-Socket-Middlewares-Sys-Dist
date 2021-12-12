package Q1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client Side");

        System.out.println("Attente de connexion");
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connexion etablie");

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un nombre :");
        int i = sc.nextInt();

        os.write(i);
        System.out.println("\nNombre envoyé");

        System.out.println("Attente de reponse");
        int rep = is.read();
        System.out.println("Reponse recu :" +rep);

        sc.close();
        s.close();
    }
}