/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entities.Dolgozo;

/**
 *
 * @author danie
 */
public class Query {

    private Database db;
    private Connection conn;
    private PreparedStatement pst;
    DatabaseMetaData dbmd = null;
    Statement createStatement = null;

    public Query() {
        this.db = new Database();
        try {
            this.conn = db.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a DatabaseMetaData (adatbázis leírása) létrehozásakor..");
            System.out.println("" + ex);
        }

        try {
            createStatement = conn.createStatement();
            ResultSet rs = dbmd.getTables(null, "APP", "DOLGOZO", null);
            if (!rs.next()) {
                createStatement.execute("CREATE TABLE dolgozo (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, nev varchar(30) NOT NULL, email varchar(100) UNIQUE NOT NULL, beosztas int NOT NULL, varosid int NOT NULL, fizetes int NOT NULL, szabadsag int NOT NULL, jelszo varchar(50)  NOT NULL )");
            }

        } catch (SQLException ex) {
            System.out.println("Valami baj van az adattáblák létrehozásakor.");
            System.out.println("" + ex);
        }

    }

    public void addUser(String nev, String email, String jelszo, String varos, int fizetes, int szabadsag, int beosztas) {
        try {
            String sql = "insert into dolgozo(nev, email, beosztas, varosId, fizetes, szabadsag, jelszo) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nev);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, beosztas);
            preparedStatement.setString(4, varos);
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 1);
            preparedStatement.setString(7, jelszo);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor");
            System.out.println("" + ex);
        }
    }

    public Dolgozo loginUser(String email, String jelszo) {
        Dolgozo dolgozo = null;
        try {
            String sql = "SELECT * FROM dolgozo WHERE email = ? AND jelszo = ?";
            if (conn != null) {
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, email);
                    pst.setString(2, jelszo);
                } catch (SQLException ex) {
                    System.out.println("Valami baj van van a createStatament (teherautó) létrehozásakor.");
                    System.out.println("" + ex);
                }
            }

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                dolgozo = new Dolgozo(rs.getInt("id"), rs.getString("nev"), rs.getString("email"), rs.getString("jelszo"), rs.getInt("beosztas"),
                        rs.getString("varosid"), rs.getInt("fizetes"), rs.getInt("szabadsag"));
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj a bejelntekzéssel");
            System.out.println("" + ex);
        }
        return dolgozo;
    }

}
