package com.company;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuPrincipalVue2 {
    private Connection conn = null;
    private ResultSet res = null;
    private PreparedStatement ps = null;
    private JLabel champGenre;
    private JLabel champTitre;
    private JLabel champDuree;
    private JLabel champDate;
    private JLabel genre;
    private JLabel titre;
    private JLabel duree;
    private JLabel date;
    static String test;
    JTable table;

    public MenuPrincipalVue2() {
        this.conn = ConnexionBD.Connexion();
        JFrame f = new JFrame("Menu principal");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        JPanel panelMenuPrincipalVue2= (JPanel) f.getContentPane();
        f.setLayout(new GridLayout(1, 2));
        panelMenuPrincipalVue2.add(TableauDeFilm());
        panelMenuPrincipalVue2.add(InformationFilm());



    }


    public JPanel TableauDeFilm(){
        JPanel panel = new JPanel();
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

            DefaultTableModel model = new DefaultTableModel(data, columns);
            table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            table.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Deplace();
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });




            panel.add(pane);



        } catch(SQLException e) {
            System.out.println("--> Exception : " + e);
        }

        return panel;
    }

    public JPanel InformationFilm(){
        JPanel panelInformationFilm = new JPanel();
        panelInformationFilm.setLayout(new GridLayout(5,1));
        panelInformationFilm.add(titreFilm());
        panelInformationFilm.add(genreFilm());
        panelInformationFilm.add(dateFilm());
        panelInformationFilm.add(dureeFilm());

        return panelInformationFilm;

    }
    public JPanel titreFilm()
    {
        JPanel panelTitreFilm = new JPanel(new FlowLayout(FlowLayout.CENTER , 50 , 5));
        titre = new JLabel("Titre:");
        panelTitreFilm.add(titre);
        champTitre = new JLabel();
        panelTitreFilm.add(champTitre);
        return  panelTitreFilm ;

    }

    public JPanel genreFilm()
    {
        JPanel panelGenreFilm = new JPanel(new FlowLayout(FlowLayout.CENTER , 50 , 5));
        genre = new JLabel("Genre:");
        panelGenreFilm.add(genre);
        champGenre = new JLabel();
        panelGenreFilm.add(champGenre);
        return  panelGenreFilm ;

    }
    public JPanel dureeFilm()
    {
        JPanel panelDureeFilm = new JPanel(new FlowLayout(FlowLayout.CENTER , 50 , 5));
        duree = new JLabel("Durée:");
        panelDureeFilm.add(duree);
        champDuree = new JLabel();
        panelDureeFilm.add(champDuree);
        return  panelDureeFilm ;

    }
    public JPanel dateFilm() {
        JPanel panelDateFilm = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        date = new JLabel("Date:");
        panelDateFilm.add(date);
        champDate = new JLabel();
        panelDateFilm.add(champDate);
        return panelDateFilm;
    }
    public void Deplace (){
        try{
            int row = table.getSelectedRow();
            this.test = (table.getModel().getValueAt(row,0).toString());
            String requet ="select * from film where titre ='"+ test +"' ";
            ps = conn.prepareStatement(requet);
            res = ps.executeQuery();
            if (res.next()){
                String t1 = res.getString("titre");
                champTitre.setText(t1);
                String t2 = res.getString("genre");
                champGenre.setText(t2);
                String t3 = res.getString("duree");
                champDuree.setText(t3);
                String t4 = res.getString("date_sortie");
                champDate.setText(t4);
            }
        }catch (Exception e5){
            System.out.println("--> Exception : " + e5);
        }
    }

    public static void main(String[] args) {
            MenuPrincipalVue2 menuPrincipalVue2 = new MenuPrincipalVue2();

    }
}



