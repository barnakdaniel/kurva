/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;
import java.util.List;
import model.Entities.Kategoria;
import model.Query;
/**
 *
 * @author sahwel
 */
public class KategoriaService {
    private Query query;

    public KategoriaService() {
        this.query = new Query();
    }
    
    private List<Kategoria> kategoriak(){
        return query.osszesKateg();
    }
    
    private void kategoriaHozzadasa(String kategoria){
        try {   
            query.kategoriaHozzadasa(kategoria);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
