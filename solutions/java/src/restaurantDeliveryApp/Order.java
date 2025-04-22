package restaurantDeliveryApp;

import java.util.List;

public class Order {
    private final String id;

    private final List<String> items;

    private String restaurantName;

    private int totalPrice;
    private boolean dispatched;
    private final int timestamp;

    public Order(String id, List<String> items, int timestamp) {
        this.id = id;
        this.items = items;
        this.timestamp = timestamp;
        this.dispatched = false;
    }

    public String getId() { return id; }
    public List<String> getItems() { return items; }
    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
    public boolean isDispatched() { return dispatched; }
    public void setDispatched(boolean dispatched) { this.dispatched = dispatched; }
    public int getTimestamp() { return timestamp; }
}
