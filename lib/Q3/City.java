package Q3;

import java.io.Serializable;

public class City implements Serializable {
    String nom;
    int population;

    public City(String n, int nh) {
        nom = n;
        population = nh;
    }

    public String toString() {
        String res;
        res="City name = "+this.nom+"\nPopulation = "+this.population;
        return res;
     }
}