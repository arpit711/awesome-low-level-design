package restaurantDeliveryApp;

import java.util.List;

class RestaurantSortedSelectionOrder implements SelectRestaurant {


    @Override
    public Restaurant selectRestaurant(List<Restaurant> restaurants, List<String> items) {
        Restaurant best = null;
        int lowestPrice = Integer.MAX_VALUE;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.canProcess(items) && restaurant.canAcceptOrder(items.size())) {
                int total = restaurant.calculateOrderTotal(items);
                if (total < lowestPrice) {
                    lowestPrice = total;
                    best = restaurant;
                }
            }
        }
        return best;
    }
}
