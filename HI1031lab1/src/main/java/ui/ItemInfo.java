package ui;

public class ItemInfo {
    private int id;
    private float price;
    private String name;
    private String description;

    public ItemInfo(int id, float price, String name, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public ItemInfo() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescr(String descr) {
        this.description = descr;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescr() {
        return description;
    }
}
