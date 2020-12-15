/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.alt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import test.alt.MyConnection;

/**
 *
 * @author HP
 */
public class AuthentificationCrud {
     Connection cnx;
     

    public AuthentificationCrud() {
         cnx = MyConnection.getInstance().getCnx();
    }
    public String getRole(String L){
        String X="" ; 
        try{
        Statement PS = cnx.createStatement();
        String req = "select rolee from utilisateur where login='"+L+"'";
        ResultSet Rs = PS.executeQuery(req);
       /*do{
          
            }while(Rs.next());
        */
          while(Rs.next()){
            System.out.println("Hello");
               X=Rs.getString(1);
          }
      }catch(Exception E ){System.out.println(E.getMessage());}
              return X;  

    }
    public boolean Login(String L,String mdp){
        boolean res=true;
                
   try {
                     Statement Ps = cnx.createStatement();
            
         String req = "select * from utilisateur where login='"+L+"' and motdepasse='"+mdp+"'";
         ResultSet Rs = Ps.executeQuery(req);
         if(Rs.next()==false){
             System.out.println("Wrong");
             System.out.println("Not a member yet Register Now");
             res=false;
         }
         
   }catch(SQLException E){System.out.println(E.getMessage());}
         
        return res ;
    }
    
    
    
}
