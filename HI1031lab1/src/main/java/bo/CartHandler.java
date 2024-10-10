package bo;

import db.CartDB;
import ui.CartInfo;

import java.util.ArrayList;
import java.util.List;

public class CartHandler {
    private Cart cart;
    public CartHandler() {
        this.cart = new Cart();
    }


    public List<CartInfo> getCartProducts(ArrayList<CartInfo> list) {
        if (list != null) {
            //CartDB c = new CartDB(list);
            return CartDB.getCartProducts(list);
        }

        return null;
    }
}
