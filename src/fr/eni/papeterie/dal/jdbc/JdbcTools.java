package fr.eni.papeterie.dal.jdbc;



import fr.eni.papeterie.dal.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static String urldb;
    private static String userdb;
    private static String passworddb;
    static {
        urldb= Settings.getProperty("urldb");
        userdb=Settings.getProperty("userdb");
        passworddb=Settings.getProperty("passworddb");
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(urldb, userdb, passworddb);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return connection;

    }
}
