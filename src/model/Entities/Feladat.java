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
    private String feladatn�v;
    private int kiadata;
    private int megkapta;
    private int kategoria;
    private String leiras;

    public Feladat(int id, String feladatn�v, int kiadata, int megkapta, int kategoria, String leiras) {
        this.id = id;
        this.feladatn�v = feladatn�v;
        this.kiadata = kiadata;
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

    public String getFeladatn�v() {
        return feladatn�v;
    }

    public void setFeladatn�v(String feladatn�v) {
        this.feladatn�v = feladatn�v;
    }

    
    
    public int getKiadata() {
        return kiadata;
    }

    public void setKiadata(int kiadata) {
        this.kiadata = kiadata;
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
