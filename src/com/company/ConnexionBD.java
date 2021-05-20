package com.company;
import javax.swing.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;



public class ConnexionBD {
    private final Connection conn = null;
    private String filename = null;
    public static String path;

    //permet la connexion a la base de données
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
    //Chemin pour choisir une photo
    public void filen(){

        try{
        JFileChooser choisir = new JFileChooser();
        choisir.showOpenDialog(null);
        File file = choisir.getSelectedFile();
        filename = file.getAbsolutePath();
        this.path = (filename);}
        catch (Exception e9){
            JOptionPane.showMessageDialog(null,"veuillez choisir une image");
        }

    }
    public String getp(){
        return path;
    }


}
