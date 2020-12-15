/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexionalt.test;

import edu.connexionalt.entities.Livre;
import edu.connexionalt.services.LivreCRUD;

/**
 *
 * @author House
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
//        on ne peut pas écrire MyConnection mc = new MyConnection ()puisque c'est private

       LivreCRUD pc = new LivreCRUD();
//pc.ajouterLivre(l);
//pc.modifierLivre(l, 1);
//pc.supprimerLivre(1);
//for(Livre l1 : pc.listerLivre()){
//           System.out.println(l1);
//       }
   }
}
