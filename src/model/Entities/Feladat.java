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
    private String feladatnév;
    private int kiadta;
    private int megkapta;
    private int kategoria;
    private String leiras;

    public Feladat(String feladatnév, int kiadta, int kategoria, String leiras) {
        this.feladatnév = feladatnév;
        this.kiadta = kiadta;
        this.kategoria = kategoria;
        this.leiras = leiras;
    }

    
    
    public Feladat(int id, String feladatnév, int kiadata, int megkapta, int kategoria, String leiras) {
        this.id = id;
        this.feladatnév = feladatnév;
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

    public String getFeladatnév() {
        return feladatnév;
    }

    public void setFeladatnév(String feladatnév) {
        this.feladatnév = feladatnév;
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
