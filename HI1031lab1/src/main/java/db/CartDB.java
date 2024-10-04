package db;

import bo.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDB extends bo.Cart{


    public CartDB(ArrayList<Cart> cart_list) {
        super();
    }

    public static List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    PreparedStatement pst = con.prepareStatement("select * from frukt where id=?");
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("title"));
                        row.setDescr(rs.getString("descr"));
                        row.setPrice(rs.getFloat("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
}
