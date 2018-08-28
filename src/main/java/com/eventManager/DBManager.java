package com.eventManager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public Connection getConnection (){
        Connection conn = null;
        String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
        String user = "ingsw";
        String psswd = "ciao";
        try {
            // Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DB_URL, user, psswd);

        }catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
