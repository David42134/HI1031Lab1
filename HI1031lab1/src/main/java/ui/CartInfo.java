package ui;

public class CartInfo extends ItemInfo{
    private int quantity;
    private int id;

    public CartInfo(int id, int quantity) {
        super();
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
