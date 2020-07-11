import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Restaurant {
    private UUID uuid;
    private HashMap<String , Integer> menu;
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
    public Restaurant(String name, String address, String telNumber, int places, boolean outside, boolean dinnerMenu, double longtitude, double latitude, UUID uuid){
        this.uuid = uuid;
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

    public void setName(String name) {
        this.name = name;
    }


    public static void main (String... args) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ListManager listManager = new ListManager();
        restaurants = listManager.load();
        restaurants.add(new Restaurant("r1", "a1", null, 13, true, true, 23.239, 45.2837));
        restaurants.add(new Restaurant("r2", "a2", "088456788", 45, true, false, 30.239, 2.327));
        restaurants.get(1).setName(listManager.findById(restaurants.get(0).getUuid()).getName());
        listManager.save(restaurants);
    }
}
