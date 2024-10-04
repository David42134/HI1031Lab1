package bo;

import db.CartDB;
import db.ItemDB;

import java.util.ArrayList;
import java.util.Collection;

public class Cart extends Item{
    private int quantity;


    static public Collection getCart(ArrayList<Cart> cart_list){
        return CartDB.getCartProducts(cart_list);
    }

    public Cart() {
        super();
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
