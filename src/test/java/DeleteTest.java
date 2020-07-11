import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTest {
    @Test
    @Order(3)
    public void TestDelete () {
        ListManager listManager = new ListManager();
        ArrayList<Restaurant> restaurants = listManager.load();
        int size = restaurants.size();
        restaurants.removeIf(i->i.getUuid()==restaurants.get(0).getUuid());
        listManager.save(restaurants);
        ArrayList<Restaurant> restaurants1 = listManager.load();
        int size1=restaurants1.size();
        assertEquals(size1, size-1);
    }
}