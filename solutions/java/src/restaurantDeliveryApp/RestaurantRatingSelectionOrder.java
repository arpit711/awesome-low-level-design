package restaurantDeliveryApp;

import java.util.List;

public class RestaurantRatingSelectionOrder implements SelectRestaurant {

    @Override
    public Restaurant selectRestaurant(List<Restaurant> restaurants, List<String> items) {
        Restaurant best = null;
        int lowestRating = 0;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.canProcess(items) && restaurant.canAcceptOrder(items.size())) {
                int rating = restaurant.getRating();
                if (rating > lowestRating) {
                    lowestRating = rating;
                    best = restaurant;
                }
            }
        }
        return best;
    }
}
