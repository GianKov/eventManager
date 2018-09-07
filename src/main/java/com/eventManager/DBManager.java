package com.eventManager;


import java.sql.*;

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

    public ResultSet executeQuery(String query){
        Connection conn=this.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try{
        prepStat=conn.prepareStatement(query);
        rs = prepStat.executeQuery();}
        catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
