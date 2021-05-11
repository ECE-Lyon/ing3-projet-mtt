package com.company;

public class Main {

    public static void main(String[] args) {
        FilmModel film = new FilmModel();


        ControllerMenuPrincipalAdministrateur controllerMenuPrincipalAdministrateur = new ControllerMenuPrincipalAdministrateur(film);


        MenuPrincipalVue menuPrincipal = new MenuPrincipalVue();
        MenuPrincipalAdministrateurVue menuPrincipalAdministrateur = new MenuPrincipalAdministrateurVue(controllerMenuPrincipalAdministrateur);



        film.addObserver(menuPrincipal);

    }
}
