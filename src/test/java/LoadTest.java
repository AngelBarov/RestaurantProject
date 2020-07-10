import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadTest {
    @Test
    public void TestLoading() {
        int howMuch=0;
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("listOfRestaurants.csv"));
            String line = br.readLine();
            while(line!=null){
                howMuch++;
                List<String> values = Arrays.asList(line.split(","));
                if(Boolean.parseBoolean(values.get(2)))restaurants.add(new Restaurant(values.get(0), values.get(1), values.get(3), Integer.parseInt(values.get(5)), Boolean.parseBoolean(values.get(6)), Boolean.parseBoolean(values.get(7)), Double.parseDouble(values.get(8)), Double.parseDouble(values.get(9))));
                else restaurants.add(new Restaurant(values.get(0), values.get(1), null,  Integer.parseInt(values.get(4)), Boolean.parseBoolean(values.get(5)), Boolean.parseBoolean(values.get(6)), Double.parseDouble(values.get(7)), Double.parseDouble(values.get(8))));
                line = br.readLine();
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