import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveTest {
    @Test
    @Order(3)
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
}