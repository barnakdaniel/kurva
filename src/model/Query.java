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
import model.Entities.Feladat;
import model.Entities.Kategoria;

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
                createStatement.execute("CREATE TABLE dolgozo (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, nev varchar(30) NOT NULL, email varchar(100) UNIQUE NOT NULL, beosztas int NOT NULL, varos varchar(50) NOT NULL, fizetes int NOT NULL, szabadsag int NOT NULL, jelszo varchar(50)  NOT NULL )");
                createStatement.execute("CREATE TABLE feladatok (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, feladatnev varchar(30) NOT NULL, leiras varchar(200)  NOT NULL, kiadta int NOT NULL, megkapta int , kategoriaId int  NOT NULL )");
                createStatement.execute("CREATE TABLE kategoriak (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, kategoria varchar(30) NOT NULL)");
            }

        } catch (SQLException ex) {
            System.out.println("Valami baj van az adattáblák létrehozásakor.");
            System.out.println("" + ex);
        }

    }

    public void addUser(String nev, String email, String jelszo, String varos, int fizetes, int szabadsag, int beosztas) {
        try {
            String sql = "insert into dolgozo(nev, email, beosztas, varos, fizetes, szabadsag, jelszo) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nev);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, beosztas);
            preparedStatement.setString(4, varos);
            preparedStatement.setInt(5, fizetes);
            preparedStatement.setInt(6, szabadsag);
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
                        rs.getString("varos"), rs.getInt("fizetes"), rs.getInt("szabadsag"));
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj a bejelntekzéssel");
            System.out.println("" + ex);
        }
        return dolgozo;
    }
    
    public List<Kategoria> osszesKateg() {
       List<Kategoria> kategoriak = new ArrayList<>();
        try {
            String sql = "SELECT * FROM kategoriak";
            if (conn != null) {
                try {
                    pst = conn.prepareStatement(sql);
                } catch (SQLException ex) {
                    System.out.println("" + ex);
                }
            }
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                kategoriak.add(new Kategoria(rs.getInt("id"), rs.getString("kategoria")));
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        return kategoriak;
    }
    
    public void kategoriaHozzadasa(String kategoria) {
        try {
            String sql = "insert into kategoriak(kategoria) values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kategoria);
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor");
            System.out.println("" + ex);
        }
    }
    
    public void feladatHozzadasa(String nev, String leiras, Dolgozo kiadta, Dolgozo megkapta, Kategoria kategoria) {
        try {
            String sql = "insert into feladatok(feladatnev, leiras, kiadta, megkapta, kategoriaId) values (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nev);
            pst.setString(2, leiras);
            pst.setInt(3, kiadta.getId());
            if(megkapta == null){
                pst.setInt(4, 0);
            }else{
                pst.setInt(4, megkapta.getId());
            }
            pst.setInt(5, kategoria.getId());
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a feladat hozzáadásakor");
            System.out.println("" + ex);
        }
    }
    
    public List<Feladat> feladatok() {
       List<Feladat> feladatok = new ArrayList<>();
        try {
            String sql = "SELECT * FROM feladatok";
            if (conn != null) {
                try {
                    pst = conn.prepareStatement(sql);
                } catch (SQLException ex) {
                    System.out.println("" + ex);
                }
            }
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                feladatok.add(new Feladat(rs.getInt("id"), rs.getString("feladatnev"),  rs.getInt("kiadta"), rs.getInt("megkapta"), rs.getInt("kategoriaId"), rs.getString("leiras")));
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        return feladatok;
    }
    
    
    public List<Feladat> feladatokEgyDolgozohoz(Dolgozo dolgozo) {
       List<Feladat> feladatok = new ArrayList<>();
        try {
            String sql = "SELECT * FROM feladatok WHERE megkapta = ?";
            if (conn != null) {
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setInt(1, dolgozo.getId());
                } catch (SQLException ex) {
                    System.out.println("" + ex);
                }
            }
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                feladatok.add(new Feladat(rs.getInt("id"), rs.getString("feladatnev"),  rs.getInt("kiadta"), rs.getInt("megkapta"), rs.getInt("kategoriaId"), rs.getString("leiras")));
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
        return feladatok;
    }
}
