import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    @Test
    @Order(1)
    public void TestSaving() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("r1", "a1", null, 13, true, true, 23.239, 45.2837));
        restaurants.add(new Restaurant("r2", "a2", "088456788", 45, true, false, 30.239, 2.327));
        ListManager listManager = new ListManager();
        listManager.save(restaurants);
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("listOfRestaurants.csv"), "UTF-8"));
            int savedR = 0;
            while(bf.readLine().toString()!=null){
                savedR++;
            }
            assertEquals(restaurants.size(), savedR);
        }catch (Exception e){}
    }
    @Test
    @Order(2)
    public void TestLoading() {
        int howMuch=0;
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("listOfRestaurants.csv"));
            String line = br.readLine();
            while(line!=null){
                howMuch++;
                List<String> values = Arrays.asList(line.split(","));
                if(Boolean.parseBoolean(values.get(2)))restaurants.add(new Restaurant(values.get(0), values.get(1), values.get(3), Integer.parseInt(values.get(4)), Boolean.parseBoolean(values.get(5)), Boolean.parseBoolean(values.get(6)), Double.parseDouble(values.get(7)), Double.parseDouble(values.get(8)), UUID.fromString(values.get(9))));
                else restaurants.add(new Restaurant(values.get(0), values.get(1), null,  Integer.parseInt(values.get(3)), Boolean.parseBoolean(values.get(4)), Boolean.parseBoolean(values.get(5)), Double.parseDouble(values.get(6)), Double.parseDouble(values.get(7)), UUID.fromString(values.get(8))));
                line = br.readLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        assertEquals(howMuch, 2);
    }
    @Test
    @Order(3)
    public void TestDelete () {
        ListManager listManager = new ListManager();
        ArrayList<Restaurant> restaurants = listManager.load();
        int size = restaurants.size();
        listManager.deleteId(restaurants.get(0).getUuid());
        restaurants.removeIf(i->i.getUuid().equals(restaurants.get(0).getUuid()));
        int size2=restaurants.size();
        ArrayList<Restaurant> restaurants1 = listManager.load();
        assertEquals(restaurants1.size(), size2);
    }
    @Test
    @Order(4)
    public void TestFindById(){
        ArrayList<Restaurant> restaurants = new ListManager().load();
        Restaurant restaurant = new ListManager().findById(restaurants.get(0).getUuid());
        assertEquals(restaurants.get(0).getName(), restaurant.getName());
    }
    @Test
    @Order(4)
    public void TestFindByName(){
        ArrayList<Restaurant> restaurants = new ListManager().load();
        Restaurant restaurant = new ListManager().findByName(restaurants.get(0).getName());
        assertEquals(restaurants.get(0).getTelNumber(), restaurant.getTelNumber());
    }
}