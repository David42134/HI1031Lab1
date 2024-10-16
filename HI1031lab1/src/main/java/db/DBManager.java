package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance() {
        if(instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
    private DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop?user=David&password=qwerty");
        }catch(Exception e) {e.printStackTrace();}
    }

    public static Connection getConnection() {
        return getInstance().con;
    }
}
