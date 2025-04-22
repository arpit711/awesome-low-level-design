package restaurantDeliveryApp;

import java.util.*;

public class Restaurant {
    private final String name;
    private int capacity;
    private final Map<String, MenuItem> menu;
    private final Queue<String> currentOrders;
    private final Set<String> servedItems;
    private final List<String> dispatchedOrders;
    private final Integer rating;

    public Restaurant(String name, Map<String, Integer> items,  int capacity, int rating) {
        this.name = name;
        this.capacity = capacity;
        this.menu = new HashMap<>();
        this.currentOrders = new LinkedList<>();
        this.servedItems = new HashSet<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            menu.put(entry.getKey(), new MenuItem(entry.getKey(), entry.getValue()));
        }
        this.dispatchedOrders = new ArrayList<>();
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void updatePrice(String menuItem, Integer price) {
        if (menu.containsKey(menuItem)) {
            menu.put(menuItem, new MenuItem(menuItem, price));
        } else System.out.println("Item not present");

    }

    public boolean canProcess(List<String> items) {
        for (String item : items) {
            if (!menu.containsKey(item)) return false;
        }
        return true;
    }

    public boolean canAcceptOrder(Integer itemCount) {
        return (currentOrders.size() + itemCount <= capacity);
    }

    public void acceptOrder(String orderId, Integer itemCount) {
        for (int i = 0; i < itemCount; i++) currentOrders.offer(orderId);
        servedItems.addAll(menu.keySet());
    }

    public void dispatchOrder(String orderId) {
        currentOrders.removeIf(id -> id.equals(orderId));
        dispatchedOrders.add(orderId);
    }

    public List<String> dispatchedOrders() {
        return dispatchedOrders;
    }

    public Map<String, MenuItem> getMenu() { return menu; }
//    public Set<String> getServedItems() { return servedItems; }

    public int calculateOrderTotal(List<String> items) {
        int total = 0;
        for (String item : items) {
            total += menu.get(item).getPrice();
        }
        return total;
    }

    public int getRating() {
        return rating;
    }
}
