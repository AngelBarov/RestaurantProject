import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveTest {
    @Test
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
    public void TestLoading() {
        int howMuch=0;
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("listOfRestaurants.csv"));
            String line = br.readLine();
            while(line!=null){
                howMuch++;
                String[] values = line.split(",");
                restaurants.add(new Restaurant(values[0], values[1], values[2], Integer.parseInt(values[3]), Boolean.parseBoolean(values[4]), Boolean.parseBoolean(values[5]), Double.parseDouble(values[6]), Double.parseDouble(values[7])));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        assertEquals(howMuch, 2);
        assertEquals(restaurants.get(0).getName(), "r1");
    }
}