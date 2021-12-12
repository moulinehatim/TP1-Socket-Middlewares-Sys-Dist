package Q3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Server Side");
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server en action\n");

        System.out.println("Waiting for connection with client...");
        Socket sock = ss.accept();
        System.out.println("connected with client\n");

        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        City city = (City) ois.readObject();
        System.out.println("the received object is :\n"+city);

        System.out.println("treatment...");
        city.population*=1.1;
        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(city);

        System.out.println("the objet after treatment : the city after 1 year :\n"+city);
        System.out.println("sent done");


        ss.close();
    }
}
