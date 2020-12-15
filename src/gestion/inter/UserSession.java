/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.inter;

import java.util.prefs.Preferences;

/**
 *
 * @author HP
 */
public final class UserSession {
    
     private static UserSession instance;
     private String login;

    public static UserSession getInstance() {
        return instance;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }


     
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserSession(String login) {
        this.login = login;
    }
    
     public static UserSession getInstace(String login) {
        if(instance == null) {
            instance = new UserSession(login);
        }
        return instance;
    }
     public static UserSession CleanUser(String L){
       if(instance != null) {
            
            instance = new UserSession(L);
        }
        return instance;
     }

    @Override
    public String toString() {
        return login;
    }

    public UserSession() {
    }
    
     
     
    
    
    
    
    
    
    
}
