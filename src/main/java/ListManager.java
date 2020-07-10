

import java.io.*;
import java.util.ArrayList;

public class ListManager {
    public ArrayList<Restaurant> load(){
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("listOfRestaurants.csv"));
            String line = br.readLine();
            while(line!=null){
                String[] values = line.split(",");
                restaurants.add(new Restaurant(values[0], values[1], values[2], Integer.parseInt(values[3]), Boolean.parseBoolean(values[4]), Boolean.parseBoolean(values[5]), Double.parseDouble(values[6]), Double.parseDouble(values[7])));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return restaurants;
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
                sb.append(restaurant.getPlaces());
                sb.append(',');
                sb.append(restaurant.isDinnerMenu());
                sb.append(',');
                if(restaurant.isNumber()){
                    sb.append(restaurant.getTelNumber().trim());
                    sb.append(',');
                }
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
