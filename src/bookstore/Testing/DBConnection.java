/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import java.sql.*;


/**
 *
 * @author PC-Hamouda
 */
public class DBConnection {
    private Connection cnx;
    private static DBConnection Instance; 
    private final String USERNAME = "sql9381563";
    private final String PASSWORD = "iv6JLxjSFX";
    private final String URL = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9381563";
    
    private DBConnection (){
        try {
        cnx = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        System.out.println("Connected to Bookstore");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    } 
    
    public static DBConnection getInstance(){
        if (Instance == null)
            Instance = new DBConnection();
        return Instance;
    }

    public Connection getCnx() {
        return cnx;
    }    
}
