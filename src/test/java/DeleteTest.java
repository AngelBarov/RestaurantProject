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
        listManager.deleteId(restaurants.get(0).getUuid());
        restaurants.removeIf(i->i.getUuid().equals(restaurants.get(0).getUuid()));
        int size2=restaurants.size();
        ArrayList<Restaurant> restaurants1 = listManager.load();
        assertEquals(restaurants1.size(), size2);
    }
}