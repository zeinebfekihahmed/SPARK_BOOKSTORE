/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.alt;

import entites.alt.Utilisateur;
import services.alt.AuthentificationCrud;
import services.alt.SendMailJava;
import services.alt.UtilisateurCRUD;


/**
 *
 * @author HP
 */
public class MainClass {
        public static void main(String[] args) throws Exception {
        MyConnection mc = MyConnection.getInstance();
        Utilisateur u= new Utilisateur("tnom","hiba","Hammamlif","hibaaskri50@gmail.com","askrihiba","AsriHiba@25","");

        UtilisateurCRUD uc = new UtilisateurCRUD();
        AuthentificationCrud au= new AuthentificationCrud();
     //SendMailJava.sendMail("hibaaskri50@gmail.com","WELCOME TO GRANDMA","Félicitations, vous êtes inscrit");
      //  au.Login("chouroukakili","Chourouk2++");
        
      
   //  uc.ajouterUtilisateur(u);
//uc.supprimerUtilisateur(u);
////        for(Utilisateur u1 : uc.listerUtilisateurs()){
//            System.out.println(u1);
//        }
//        
    }
}
