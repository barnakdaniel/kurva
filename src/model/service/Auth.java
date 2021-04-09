/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;


import model.Entities.Dolgozo;
import model.Query;

/**
 *
 * @author sahwel
 */
public class Auth {

    private Query query = new Query();

    public Dolgozo login(String email, String jelszo) {
        return query.loginUser(email, jelszo);
    }

    public void register(String email, String jelszo, String nev, int varosId, int beosztas, int fizetes, int szabadsag){
        validation(email, jelszo, nev, varosId, beosztas, fizetes, szabadsag);
       // query.addUser(nev, email,  jelszo, varosId, fizetes, szabadsag, beosztas);
    }
    
    private void validation(String email, String jelszo, String nev, int varosId, int beosztas, int fizetes, int szabadsag){
            if(email.length() < 5 || email.length() > 100) {
                System.err.println("Nem jó az email hossza");
                return;
            }
            if(jelszo.length() < 5 || jelszo.length() > 50) {
                System.err.println("Nem jó az jelszo hossza");
                return;
            }
            if(nev.length() < 5 || nev.length() > 30) {
                System.err.println("Nem jó az nev hossza");
                return;
            }
            if(!(email.contains("@") && email.contains("."))){
                System.err.println("Valdi email címet adjon meg!");
                return;
            }
            if(!nev.contains(" ")){
                System.err.println("Valdi nevet adjon meg!");
                return;
            }
    }
}
