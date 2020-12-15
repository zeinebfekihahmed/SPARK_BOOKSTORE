/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.bookstore.entites.Offre;
import edu.bookstore.services.OffreCRUD;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dridi
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        
 Offre f = new Offre(1,"offre 1");
        OffreCRUD pc = new OffreCRUD();
        //pc.afficherOffre(f);
        //pc.ajouterOffre(f);
       pc.supprimerOffre(f);
            //pc.modiferOffre(f,4);
    }
    
}

