package com.company;


import javax.swing.*;
import java.awt.*;

public class ControllerMenuPrincipalAdministrateur {
    private final FilmModel film;



    public ControllerMenuPrincipalAdministrateur(FilmModel film) {

        this.film = film;

    }


    public void MiseAJourFilm(String genre, String titre, String date, String runningTime, ImageIcon image) {
        film.setTitre(titre);
        film.setGenre(genre);
        film.setDate(date);
        film.setRunningtime(runningTime);
        film.setImage(image);
    }
}