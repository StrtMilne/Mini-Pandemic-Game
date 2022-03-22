package models.cities;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseGameCities implements Cities{

    public ArrayList<HashMap<String, String>> cities;

    public BaseGameCities() {
        this.cities = new ArrayList<>();
    }

    public ArrayList<HashMap<String, String>> getCities() {
        return this.cities;
    }

    public ArrayList<HashMap<String, String>> passCities() {
        HashMap<String, String> london = new HashMap<>();
        london.put("name", "London");
        london.put("colour", "blue");
        london.put("population", "8.9");

        this.cities.add(london);

        HashMap<String, String> paris = new HashMap<>();
        paris.put("name", "Paris");
        paris.put("colour", "blue");
        paris.put("population", "2.2");

        this.cities.add(paris);

        HashMap<String, String> atlanta = new HashMap<>();
        atlanta.put("name", "Atlanta");
        atlanta.put("colour", "blue");
        atlanta.put("population", "0.5");

        this.cities.add(atlanta);

        HashMap<String, String> madrid = new HashMap<>();
        madrid.put("name", "Madrid");
        madrid.put("colour", "blue");
        madrid.put("population", "3.2");

        this.cities.add(madrid);

        HashMap<String, String> tokyo = new HashMap<>();
        tokyo.put("name", "Tokyo");
        tokyo.put("colour", "red");
        tokyo.put("population", "13.9");

        this.cities.add(tokyo);

        HashMap<String, String> shanghai = new HashMap<>();
        shanghai.put("name", "Shanghai");
        shanghai.put("colour", "red");
        shanghai.put("population", "26.3");

        this.cities.add(shanghai);

        HashMap<String, String> osaka = new HashMap<>();
        osaka.put("name", "Osaka");
        osaka.put("colour", "red");
        osaka.put("population", "2.7");

        this.cities.add(osaka);

        HashMap<String, String> seoul = new HashMap<>();
        seoul.put("name", "Seoul");
        seoul.put("colour", "red");
        seoul.put("population", "9.8");

        this.cities.add(seoul);

        HashMap<String, String> santiago = new HashMap<>();
        santiago.put("name", "Santiago");
        santiago.put("colour", "yellow");
        santiago.put("population", "4.9");

        this.cities.add(santiago);

        HashMap<String, String> lima = new HashMap<>();
        lima.put("name", "Lima");
        lima.put("colour", "yellow");
        lima.put("population", "9.7");

        this.cities.add(lima);

        HashMap<String, String> losAngeles = new HashMap<>();
        losAngeles.put("name", "Los Angeles");
        losAngeles.put("colour", "yellow");
        losAngeles.put("population", "3.9");

        this.cities.add(losAngeles);

        HashMap<String, String> buenosAries = new HashMap<>();
        buenosAries.put("name", "Buenos Aries");
        buenosAries.put("colour", "yellow");
        buenosAries.put("population", "3.9");

        this.cities.add(buenosAries);

        HashMap<String, String> mumbai = new HashMap<>();
        mumbai.put("name", "Mumbai");
        mumbai.put("colour", "black");
        mumbai.put("population", "21.0");

        this.cities.add(mumbai);

        HashMap<String, String> cairo = new HashMap<>();
        cairo.put("name", "Cairo");
        cairo.put("colour", "black");
        cairo.put("population", "9.5");

        this.cities.add(cairo);

        HashMap<String, String> riyadh = new HashMap<>();
        riyadh.put("name", "Riyadh");
        riyadh.put("colour", "black");
        riyadh.put("population", "7.7");

        this.cities.add(riyadh);

        HashMap<String, String> baghdad = new HashMap<>();
        baghdad.put("name", "Baghdad");
        baghdad.put("colour", "black");
        baghdad.put("population", "7.6");

        this.cities.add(baghdad);

        return this.cities;
    }
}
