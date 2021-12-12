package Q3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        System.out.println("Client Side");

        System.out.println("Waiting for connection");
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name :");
        String cityName = sc.next();
        System.out.println("Enter the city population :");
        int cityPopulation = sc.nextInt();
        City city = new City(cityName , cityPopulation);
        System.out.println("Your city is :\n"+city);

        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(city);
        System.out.println("\nObject sent\n");

        System.out.println("Waiting for response...");
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        city = (City) ois.readObject();
        System.out.println("the received object is :\n"+city);

        sc.close();
        s.close();
    }
}

