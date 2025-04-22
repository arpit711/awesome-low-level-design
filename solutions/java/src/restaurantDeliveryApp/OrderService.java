package restaurantDeliveryApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final Map<String, Restaurant> restaurants = new HashMap<>();
    private final Map<String, List<String>> orderDetails = new HashMap<>();
    private final List<String> dispatchedOrders = new ArrayList<>();
    private final SelectRestaurant strategy = new RestaurantSortedSelectionOrder();
//    private final SelectRestaurant strategy = new RestaurantSortedSelectionOrder();

    public void onboardRestaurant(String name, Map<String, Integer> items, int capacity) {
        restaurants.put(name, new Restaurant(name, items, capacity, 4));
    }

    public void updatePrice(String restaurantName, String itemName, int newPrice) {
            restaurants.get(restaurantName).updatePrice(itemName, newPrice);

            System.out.println("Updated Menu for " + restaurantName + ": ");
            for (Map.Entry<String, MenuItem> entrySet : restaurants.get(restaurantName).getMenu().entrySet()) {
                System.out.print(entrySet.getValue().getName() + " ");
            }
        System.out.println();
    }

    public void placeOrder(String orderId, List<String> items) {
        Restaurant selected = strategy.selectRestaurant(new ArrayList<>(restaurants.values()), items);
        if (selected != null) {
            selected.acceptOrder(orderId, items.size());

            orderDetails.put(orderId, items);
            int total = selected.calculateOrderTotal(items);

            System.out.println("Order " + orderId + " placed at " + selected.getName() + ". Total: Rs." + total);
        } else {
            System.out.println("Order " + orderId + " could not be placed due to unavailable items or capacity.");
        }
    }

    public void dispatchOrder(String orderId) {
        if (!orderDetails.containsKey(orderId))
            System.out.println("Above order not part of Placed orders can't be dispatched");
        else {
            for (Restaurant r : restaurants.values()) {
                r.dispatchOrder(orderId);
            }

            dispatchedOrders.add(orderId);
            System.out.println("Order " + orderId + " has been dispatched.");
        }
    }

    public void printDispatchedOrders() {
        System.out.println("Dispatched Orders: " + dispatchedOrders);
    }

    public void printDispatchedOrders(Restaurant restaurantObj) {
        for (String dispatchedItems: restaurantObj.dispatchedOrders())
            System.out.println(dispatchedItems);
    }
    }

