import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.UUID;

public class Restaurant {
    private UUID uuid;
    private int places;
    private boolean dinnerMenu, outside, number;
    private double longtitude, latitude;
    private String name, telNumber, address;
    public Restaurant(String name, String address, String telNumber, int places, boolean outside, boolean dinnerMenu, double longtitude, double latitude){
        this.uuid = UUID.randomUUID();
        this.address=address;
        this.name=name;
        this.places=places;
        this.outside=outside;
        this.dinnerMenu=dinnerMenu;
        this.longtitude=longtitude;
        this.latitude=latitude;
        if(telNumber!=null)this.number=true;
        this.telNumber=telNumber;
    }

    public String getName() {
        return name;
    }

    public int getPlaces() {
        return places;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public boolean isDinnerMenu() {
        return dinnerMenu;
    }

    public boolean isNumber() {
        return number;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isOutside() {
        return outside;
    }

    public static void main (String... args) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ListManager listManager = new ListManager();
        restaurants = listManager.load();
        restaurants.add(new Restaurant("Skara Bara", "Poligraficheski kombinat", null,60, true, true, 239.012901, 102.219));
        restaurants.add(new Restaurant("Mimas", "Grafa", "0885524612", 15, true, false, 49.012901, 32.219));
        listManager.save(restaurants);
    }
}
