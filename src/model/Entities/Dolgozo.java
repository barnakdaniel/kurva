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
public class Dolgozo {
    private int id;
    private String nev;
    private String email;
    private String jelszo;
    private int beosztas;
    private String varos;
    private int fizetes;
    private int szabadsag;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public int getId() {
        return id;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
    
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

    public String getVarosId() {
        return varos;
    }

    public void setVarosId(String varos) {
        this.varos = varos;
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

    public Dolgozo() {
    }

    public Dolgozo(int id, String nev,  String email, String jelszo, int beosztas, String varos, int fizetes, int szabadsag) {
        this.id= id;
        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
        this.beosztas = beosztas;
        this.varos = varos;
        this.fizetes = fizetes;
        this.szabadsag = szabadsag;
    }
    
    
    
}
