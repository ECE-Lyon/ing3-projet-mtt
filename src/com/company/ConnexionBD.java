package com.company;
import java.sql.Connection;
import java.sql.DriverManager;



public class ConnexionBD {
    Connection conn = null;

    public static Connection Connexion(){
        try{

            Connection conn = DriverManager.getConnection("jdbc:h2:./default");
            if (conn!= null){System.out.println("connexion réussi");}
            else{System.out.println("problème de connexion");}
            return conn;
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            return null;
        }
    }
    public static void main(String[] args) {





    }

}
