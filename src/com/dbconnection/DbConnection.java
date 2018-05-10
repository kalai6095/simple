package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection conn = null;
    private String URL = "jdbc:mysql://localhost:3306/struts?useSSL=false";
    private String USERNAME = "root";
    private String PASSWORD = "admin";
    private String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection connect() {
        try {
            Class.forName(DRIVER);
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
