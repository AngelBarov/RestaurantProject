import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveTest {
    @Test
    public void TestSaving() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("r1", "a1", 23, true, true, 19.9238, 23.239));
        restaurants.add(new Restaurant("r2", "a2", 14, false, true, 19.9348, 30.239));
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