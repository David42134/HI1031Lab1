package db;

import bo.Cart;
import ui.CartInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDB extends bo.Cart{


    public CartDB(ArrayList<CartInfo> cart_list) {
        super();
    }

    public static List<CartInfo> getCartProducts(ArrayList<CartInfo> cartList) {
        List<CartInfo> cartInfos = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            if (cartList.size() > 0) {
                for (CartInfo item : cartList) {
                    PreparedStatement pst = con.prepareStatement("select * from frukt where id=?");
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        CartInfo row = new CartInfo(rs.getInt("id"),item.getQuantity());
                        row.setName(rs.getString("title"));
                        row.setDescr(rs.getString("descr"));
                        row.setPrice(rs.getFloat("price")*item.getQuantity());
                        cartInfos.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return cartInfos;
    }
}
