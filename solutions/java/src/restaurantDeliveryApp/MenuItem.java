package restaurantDeliveryApp;

public class MenuItem {
    public MenuItem(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    String name;
    Integer price;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
