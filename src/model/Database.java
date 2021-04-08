/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author danie
 */
public class Database {
    private final String HOST;
    private final String DBNAME;
    private final String DRIVER;
    private final String USERNAME;
    private final String PASSWORD;

    public Database() {
        this.HOST = "jdbc:mysql://localhost:3306/";
        this.DBNAME = "zd?useUnicode=true&characterEncoding=UTF-8";
        this.DRIVER = "com.mysql.jdbc.Driver";
        this.USERNAME = "root";
        this.PASSWORD = "";
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER); // A JDBC driver regisztrációja
        return DriverManager.getConnection(HOST + DBNAME, USERNAME, PASSWORD); // Kapcsolat megnyitása;
    }
}