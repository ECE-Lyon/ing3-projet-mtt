package com.company;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuPrincipalVue2 {
    private Connection conn = null;
    private ResultSet res = null;
    private PreparedStatement ps = null;

    public MenuPrincipalVue2() {
        conn = ConnexionBD.Connexion();
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
                String duree = res.getString("durée");
                String date = res.getString("date de sortie");
                data[i][0] = titre;
                data[i][1] = genre;
                data[i][2] = duree;
                data[i][2] = date;

                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Menu principal");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 250);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            System.out.println("--> Exception : " + e);
        }
    }
    public static void main(String[] args) {
            MenuPrincipalVue2 menuPrincipalVue2 = new MenuPrincipalVue2();

    }
}



