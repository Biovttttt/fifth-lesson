package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static Connection Connection(){
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
            System.out.println("Connection succes!!!");
        }catch (SQLException e){
            System.out.println("Failed to make connection to database");
            e.printStackTrace();

        }

        return connection;
    }
}
