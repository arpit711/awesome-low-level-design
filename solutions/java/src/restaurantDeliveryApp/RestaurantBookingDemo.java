package restaurantDeliveryApp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestaurantBookingDemo {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        Map<String, Integer> menu1 = new HashMap<>() {{
            put("item1", 100);
            put("item2", 150);
        }};
        service.onboardRestaurant("restaurant1", menu1, 5);

        Map<String, Integer> menu2 = new HashMap<>() {{
            put("item1", 80);
            put("item2", 120);
            put("item3", 90);
        }};
        service.onboardRestaurant("restaurant2", menu2, 3);


        service.updatePrice("restaurant2", "item1", 70);
        service.placeOrder("order1", Arrays.asList("item1"));
        service.placeOrder("order2", Arrays.asList("item1", "item2", "item3"));
        service.dispatchOrder("order2");
        service.placeOrder("order3", Arrays.asList("item2", "item3"));

        // Bonus
        service.printDispatchedOrders();
    }

}