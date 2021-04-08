/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entities.User;

/**
 *
 * @author danie
 */
public class Query {

    private Database db;
    private Connection conn;
    private PreparedStatement pst;

    public Query() {
        this.db = new Database();
        try {
            this.conn = db.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addUser(String nev, String beosztas, String jelszo, int varosId, int fizetes, int szabadsag) {
        try {
            String sql = "insert into dolgozo values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nev);
            preparedStatement.setString(2, beosztas);
            preparedStatement.setString(3, jelszo);
            preparedStatement.setInt(3, varosId);
            preparedStatement.setInt(4, fizetes);
            preparedStatement.setInt(5, szabadsag);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor");
            System.out.println("" + ex);
        }
    }

    public User loginUser(String nev, String jelszo) {
        User dolgozo = null;

        try {
            String sql = "SELECT * FROM dolgozo WHERE nev =" + nev + "AND jelszo =" + jelszo;
            if (conn != null) {
                try {
                    pst = conn.prepareStatement(sql);
                } catch (SQLException ex) {
                    System.out.println("Valami baj van van a createStatament (teherautó) létrehozásakor.");
                    System.out.println("" + ex);
                }
            }

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                dolgozo = new User(rs.getInt("id"), rs.getString("nev"), rs.getString("jelszo"), rs.getInt("beosztas"),
                rs.getInt("varodId"), rs.getInt("fizetes"), rs.getInt("szabadsag"));
            }
            System.out.println(dolgozo.getNev());
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor");
            System.out.println("" + ex);
        }
        return dolgozo;
    }

}
