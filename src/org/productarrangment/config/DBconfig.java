package org.productarrangment.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconfig {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/product";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    
    protected Connection conn; 

    public DBconfig() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
