

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ListManager {
    public ArrayList<Restaurant> load(){
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("listOfRestaurants.csv"));
            String line = br.readLine();
            while(line!=null){
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
        return restaurants;
    }
    public void deleteId(UUID uuid){
        ArrayList<Restaurant> restaurants = load();
        restaurants.removeIf(i->i.getUuid()==uuid);
        save(restaurants);
    }
    public void save(ArrayList<Restaurant> restaurants){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("listOfRestaurants.csv"), "UTF-8"));
            for(Restaurant restaurant : restaurants) {
                StringBuffer sb = new StringBuffer();
                sb.append(restaurant.getName().trim());
                sb.append(',');
                sb.append(restaurant.getAddress().trim());
                sb.append(',');
                sb.append(restaurant.isNumber());
                sb.append(',');
                if(restaurant.isNumber()){
                    sb.append(restaurant.getTelNumber().trim());
                    sb.append(',');
                }
                sb.append(restaurant.getPlaces());
                sb.append(',');
                sb.append(restaurant.isOutside());
                sb.append(',');
                sb.append(restaurant.isDinnerMenu());
                sb.append(',');
                sb.append(restaurant.getLongtitude());
                sb.append(',');
                sb.append(restaurant.getLatitude());
                sb.append(',');
                sb.append(restaurant.getUuid().toString());
                bufferedWriter.write(sb.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
