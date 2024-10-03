package ui;

public class ItemInfo {
    private float price;
    private String name;
    private String description;

    public ItemInfo(float price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
