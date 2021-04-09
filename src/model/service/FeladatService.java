/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;
import java.util.List;
import model.Entities.Dolgozo;
import model.Entities.Feladat;
import model.Entities.Kategoria;
import model.Query;

public class FeladatService {
    private Query query;
    
     public FeladatService() {
        this.query = new Query();
    }
    public List<Feladat> egyDolgozFeladati(Dolgozo dolgozo){
        
        return query.feladatokEgyDolgozohoz(dolgozo);
    }
    
    public List<Feladat> osszesFeladat(Dolgozo dolgozo){
        if(dolgozo.getBeosztas() < 2) return null;
        
        return query.feladatok();
    }
    
    public void feladatHozzadasa(Dolgozo kiadta, Dolgozo megkapta, String nev, String leiras, Kategoria kategoria){
        if(kiadta.getBeosztas() < 2) return;
        
        try {
            query.feladatHozzadasa(nev, leiras, kiadta, megkapta, kategoria);
        } catch (Exception e) {
            System.out.println(e);
        }
      
    }
    
    
}
