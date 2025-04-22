package restaurantDeliveryApp;

import java.util.List;

public interface SelectRestaurant {
    Restaurant selectRestaurant(List<Restaurant> restaurants, List<String> items);
}
