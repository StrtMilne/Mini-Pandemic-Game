package models.cities;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseGameCities {

    public ArrayList<HashMap> cities;

    public BaseGameCities() {
        this.cities = new ArrayList();
    }

    public ArrayList getCities() {
        return this.cities;
    }

    public ArrayList passCities() {
        HashMap<String, String> london = new HashMap<>();
        london.put("name", "London");
        london.put("colour", "blue");
        london.put("population", "9");

        this.cities.add(london);

        HashMap<String, String> tokyo = new HashMap<>();
        london.put("name", "Tokyo");
        london.put("colour", "red");
        london.put("population", "14");

        this.cities.add(tokyo);

        HashMap<String, String> santiago = new HashMap<>();
        london.put("name", "Santiago");
        london.put("colour", "yellow");
        london.put("population", "5");

        this.cities.add(santiago);

        HashMap<String, String> mumbai = new HashMap<>();
        london.put("name", "Mumbai");
        london.put("colour", "black");
        london.put("population", "21");

        this.cities.add(mumbai);

        return this.cities;
    };
}
