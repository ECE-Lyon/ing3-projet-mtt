package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class MenuPrincipalVue extends JFrame implements Observer{

    private JLabel genre1;
    private JLabel duree1;
    private JLabel anneeDeSortie1;
    private JLabel titre1;
    private JLabel photo;
    private File file = null ;



    public MenuPrincipalVue() throws HeadlessException {
        super("Menu principal");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        JPanel panelMenuPrincipal = (JPanel) this.getContentPane();
        setLayout(new GridLayout(   2 , 1));
        panelMenuPrincipal.add(panelAffichageFilmParSalle());
        panelMenuPrincipal.add(DivisionDeChoixDuFilm());




    }

    public JPanel panelAffichageFilmParSalle(){

        JPanel divisionSalle = new JPanel(new GridLayout(1,1));
        divisionSalle.add(DivisionFilm());

        return divisionSalle ;
    }

    public JPanel DivisionFilm(){

        JPanel panelDivisionFilm = new JPanel(new GridLayout(6,1));
        panelDivisionFilm.add(Photo());
        panelDivisionFilm.add(InformationFilm());

        return panelDivisionFilm ;
    }

    public JPanel Photo(){
        JPanel panelPhoto = new JPanel();
        photo = new JLabel();
        panelPhoto.add(photo);

        return panelPhoto;
    }
    public JPanel InformationFilm(){
        JPanel panelInformationFilm = new JPanel(new GridLayout(3,1));
        panelInformationFilm.add(Titredufilm());
        panelInformationFilm.add(Genredufilm());
        panelInformationFilm.add(DureeEtAnneeDeSortiedufilm());

        return panelInformationFilm;
    }

    public JPanel Titredufilm(){
        JPanel panelTitreFilm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titre2 = new JLabel("Titre: ");
        panelTitreFilm.add(titre2);
        titre1 = new JLabel();
        panelTitreFilm.add(titre1);
        return panelTitreFilm;
    }

    public JPanel Genredufilm(){
        JPanel panelGenreFilm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Genre2 = new JLabel("Genre: ");
        panelGenreFilm.add(Genre2);
        genre1 = new JLabel();
        panelGenreFilm.add(genre1);
        return panelGenreFilm;
    }

    public JPanel DureeEtAnneeDeSortiedufilm(){
        JPanel panelDureeEtAnneeDeSortieDuFilm = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel AnneeDeSortie2 = new JLabel("Année de sortie: ");
        panelDureeEtAnneeDeSortieDuFilm.add(AnneeDeSortie2);
        anneeDeSortie1 = new JLabel();
        panelDureeEtAnneeDeSortieDuFilm.add(anneeDeSortie1);
        JLabel Duree2 = new JLabel("Durée: ");
        panelDureeEtAnneeDeSortieDuFilm.add(Duree2);
        duree1 = new JLabel();
        panelDureeEtAnneeDeSortieDuFilm.add(duree1);

        return panelDureeEtAnneeDeSortieDuFilm;
    }

    public JPanel DivisionDeChoixDuFilm(){
        JPanel panelDivisionDeChoixDuFilm = new JPanel(new GridLayout(5,1));

        panelDivisionDeChoixDuFilm.add(DemandeLeChoixDuFilm());

        panelDivisionDeChoixDuFilm.add(ChoixFilm());

        panelDivisionDeChoixDuFilm.add(NombreDeTicket());
        panelDivisionDeChoixDuFilm.add(BoutonAchat());



        return panelDivisionDeChoixDuFilm;
    }

    public JPanel DemandeLeChoixDuFilm(){
        JPanel panelDemandeLeChoixDuFilm = new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
        JLabel PhraseDemandeLeChoixDuFilm = new JLabel("Choisissez le film que vous voulez regarder");
        panelDemandeLeChoixDuFilm.add(PhraseDemandeLeChoixDuFilm);
        return panelDemandeLeChoixDuFilm;
    }



    public JPanel ChoixFilm(){

        JPanel panelChoixDuFilm = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
        JCheckBox CheckFilm1 = new JCheckBox("film");
        panelChoixDuFilm.add(CheckFilm1);


        return panelChoixDuFilm;

    }


    public JPanel NombreDeTicket(){
        JPanel panelNombreDeTicket = new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
        JLabel NombreDeTicket = new JLabel("Combien de ticket voulez vous :");
        panelNombreDeTicket.add(NombreDeTicket);
        JTextField ChampsNombreDeTicket = new JTextField(20);
        panelNombreDeTicket.add(ChampsNombreDeTicket);
        return panelNombreDeTicket;

    }
    public JPanel BoutonAchat(){
        JPanel panelBoutonAchat = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton Achat = new JButton("Acheter");
        panelBoutonAchat.add(Achat);
        return panelBoutonAchat;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.genre1.setText(((FilmModel) arg).getGenre());
        this.duree1.setText(String.valueOf(((FilmModel)arg).getRunningtime()));
        this.titre1.setText(((FilmModel) arg).getTitre());
        this.anneeDeSortie1.setText(((FilmModel) arg).getDate());
        this.photo.setIcon((Icon) ((FilmModel)arg).getImage());

    }


//carte de fidelite


    public static void main(String[] args) {
        MenuPrincipalVue panelMenuPrincipal= new MenuPrincipalVue() ;

    }

}