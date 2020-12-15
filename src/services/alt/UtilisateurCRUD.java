/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.alt;

import entites.alt.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import test.alt.MyConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class UtilisateurCRUD {
    Connection cnx;
    int i=0;
  final String pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
  final String pattern1 ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{8,}$";
    public UtilisateurCRUD() {
         cnx = MyConnection.getInstance().getCnx();
    }
    public static boolean pregMatch(String pattern, String content){
    return content.matches(pattern);}
      public static boolean pregMatch1(String pattern1, String content1){
    return content1.matches(pattern1);}
     
    public void ajouterUtilisateur(Utilisateur u){
     try {
            
            String requete = "INSERT INTO utilisateur (nom,prenom,adresse,email,login,motdepasse,rolee) "
                    + "VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement pst = cnx
                                           .prepareStatement(requete);
          
            pst.setString(1, u.getnom());
            pst.setString(2, u.getprenom());
            pst.setString(3, u.getadresse());
            if(pregMatch(pattern, u.getemail())){
                pst.setString(4, u.getemail());
            };
            
            pst.setString(5, u.getlogin());
            if(pregMatch1(pattern1,u.getmotdepasse())){    
            pst.setString(6, u.getmotdepasse());}
            System.out.println(u.getrolee());
            pst.setString(7,u.getrolee());
            
            pst.executeUpdate();
            System.out.println("Utilisateur ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
     
    /**
     *
     * @return
     */
    public List<Utilisateur> listerUtilisateurs(){
         List<Utilisateur> myList = new ArrayList<Utilisateur>();
         try {
            String requete= "SELECT * FROM utilisateur";
            Statement st = cnx
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Utilisateur u = new Utilisateur();
                u.setid(rs.getInt(1));
                u.setnom(rs.getString(3));
                u.setprenom(rs.getString("prenom"));
                u.setadresse(rs.getString("adresse"));
                u.setemail(rs.getString("email"));
                u.setlogin(rs.getString("login"));
                u.setmotdepasse(rs.getString("motdepasse"));
                myList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }
    public boolean supprimerUtilisateur(Utilisateur u){
        boolean etat = false;
        try {
            
            String Req2 = "select id from utilisateur where nom='"+u.getnom()+"'and prenom= '"+u.getprenom()+"'";
                        System.out.println(u.getprenom());
            System.out.println(u.getnom());
                        System.out.println(Req2);

            Statement Ps2 = cnx.createStatement();
            ResultSet Rs =  Ps2.executeQuery(Req2);
            
            String requete = "DELETE FROM utilisateur WHERE id=?";
            System.out.println(requete);
            PreparedStatement pst = cnx.prepareStatement(requete);
             while(Rs.next()){  
            pst.setInt(1,Rs.getInt(1));
            i= pst.executeUpdate();
             }
           if(i>0){
            System.out.println("Utilisateur supprimé");
            etat=true;
           }else{System.out.println("Not deleted");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return etat;
     }

  

   
    }
    
    

