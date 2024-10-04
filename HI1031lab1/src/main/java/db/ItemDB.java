package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends bo.Item{
    public static Collection searchItems(String item_group){
        Vector v = new Vector();
        try {

            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM frukt WHERE id > 0");
            while(rs.next()){
                int i = rs.getInt("id");
                float price = rs.getFloat("price");
                String name = rs.getString("title");
                String desc = rs.getString("descr");
                v.addElement(new ItemDB(i,price,name,desc));
            }
        }catch (SQLException e) {e.printStackTrace();}

        return v;
    }



    private ItemDB(int id, float price, String name, String descr) {
        super(id, price, name, descr);
    }
}
