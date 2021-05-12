package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MenuPrincipalAdminstrateurVue {

    private Connection conn = null;
    private ResultSet res = null;
    private PreparedStatement ps = null;
    private JButton supprimer ;
    private JButton ajouter ;
    private ControllerMenuPrincipalAdministrateur controllerMenuPrincipalAdministrateur;
    private JTable table;
    private DefaultTableModel model;

    public MenuPrincipalAdminstrateurVue() {
        this.conn = ConnexionBD.Connexion();
        JFrame menuPrincipalAdmin = new JFrame("Menu principal");
        menuPrincipalAdmin.setSize(600, 600);
        menuPrincipalAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuPrincipalAdmin.setVisible(true);
        JPanel panelMenuPrincipalVue2= (JPanel) menuPrincipalAdmin.getContentPane();
        menuPrincipalAdmin.setLayout(new GridLayout(2, 1));
        panelMenuPrincipalVue2.add(TableauDeFilm());
        panelMenuPrincipalVue2.add(boutonSupprimerAjouter());

    }

    public JPanel TableauDeFilm(){
        JPanel panelTableauFilm = new JPanel();
        try
        {


            String query = "SELECT * FROM film";

            Statement stm = conn.createStatement();
            res = stm.executeQuery(query);

            String columns[] = { "titre", "genre", "durée" ,"date de sortie","image"};
            String data[][] = new String[8][3];

            int i = 0;
            while (res.next()) {
                String titre = res.getString("titre");
                String genre = res.getString("genre");
                String duree = res.getString("duree");
                String date = res.getString("date_sortie");
                data[i][0] = titre;
                data[i][1] = genre;
                data[i][2] = duree;
                data[i][2] = date;

                i++;
            }


            model = new DefaultTableModel(data, columns);
            table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);

            panelTableauFilm.add(pane);



        } catch(SQLException e) {
            System.out.println("--> Exception : " + e);
        }finally{
        try{
            ps.close();
            res.close();
        }catch (Exception e3){
            System.out.println("--> Exception : " + e3);
        }
    }

        return panelTableauFilm;
    }

    public JPanel boutonSupprimerAjouter(){

        JPanel panelBoutonSupprimerAjouter = new JPanel();
        panelBoutonSupprimerAjouter.setLayout(new FlowLayout(FlowLayout.CENTER ,50,100));
        supprimer = new JButton("supprimer");
        panelBoutonSupprimerAjouter.add(supprimer);
        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    // vérifier d'abord la ligne sélectionnée
                    if(table.getSelectedRow() != -1) {
                        // supprimer la ligne sélectionnée du modèle de table
                        model.removeRow(table.getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Deleted successfully");

                    }

            }
        });
        ajouter = new JButton("ajouter");
        panelBoutonSupprimerAjouter.add(ajouter);
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AjoutFilmVue ajoutFilmVue = new AjoutFilmVue(controllerMenuPrincipalAdministrateur);
            }
        });



        return panelBoutonSupprimerAjouter;
    }

    public static void main(String[] args) {



        MenuPrincipalAdminstrateurVue menuPrincipalAdministrateur = new MenuPrincipalAdminstrateurVue();



    }
}
