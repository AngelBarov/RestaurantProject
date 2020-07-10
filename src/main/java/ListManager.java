import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ListManager {
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
