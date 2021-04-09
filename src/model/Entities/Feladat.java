/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

/**
 *
 * @author sahwel
 */
public class Feladat {
    private int id;
    private String feladatnÚv;
    private int kiadta;
    private int megkapta;
    private int kategoria;
    private String leiras;

    public Feladat(String feladatnÚv, int kiadta, int kategoria, String leiras) {
        this.feladatnÚv = feladatnÚv;
        this.kiadta = kiadta;
        this.kategoria = kategoria;
        this.leiras = leiras;
    }

    
    
    public Feladat(int id, String feladatnÚv, int kiadata, int megkapta, int kategoria, String leiras) {
        this.id = id;
        this.feladatnÚv = feladatnÚv;
        this.kiadta = kiadta;
        this.megkapta = megkapta;
        this.kategoria = kategoria;
        this.leiras = leiras;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeladatnÚv() {
        return feladatnÚv;
    }

    public void setFeladatnÚv(String feladatnÚv) {
        this.feladatnÚv = feladatnÚv;
    }

    
    
    public int getKiadta() {
        return kiadta;
    }

    public void getKiadta(int kiadta) {
        this.kiadta = kiadta;
    }

    public int getMegkapta() {
        return megkapta;
    }

    public void setMegkapta(int megkapta) {
        this.megkapta = megkapta;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
    
    
}
