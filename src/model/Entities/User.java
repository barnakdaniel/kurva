/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

/**
 *
 * @author danie
 */
public class User {
    private int id;
    private String nev;
    private String jelszo;
    private int beosztas;
    private int varosId;
    private int fizetes;
    private int szabadsag;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getBeosztas() {
        return beosztas;
    }

    public void setBeosztas(int beosztas) {
        this.beosztas = beosztas;
    }

    public int getVarosId() {
        return varosId;
    }

    public void setVarosId(int varosId) {
        this.varosId = varosId;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    public int getSzabadsag() {
        return szabadsag;
    }

    public void setSzabadsag(int szabadsag) {
        this.szabadsag = szabadsag;
    }

    public User() {
    }

    public User(int id,String nev, String jelszo,int beosztas, int varosId, int fizetes, int szabadsag) {
        this.id= id;
        this.nev = nev;
        this.jelszo = jelszo;
        this.beosztas = beosztas;
        this.varosId = varosId;
        this.fizetes = fizetes;
        this.szabadsag = szabadsag;
    }
    
    
    
}
