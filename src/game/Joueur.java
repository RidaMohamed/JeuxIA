package game;

import java.util.ArrayList;

public class Joueur {

    private String name ;
    private int identifiant;
    private int nbPions;
    private int nbMouvement;
    private int nbPionsPrises;
    private int monTour ;// 1 cad c'est le tour de ce joueur 0 non

    public Joueur(String name, int identifiant, int nbPions , int Tour) {
        this.name = name;
        this.identifiant = identifiant;
        this.nbPions = nbPions;
        this.nbMouvement = 0;
        this.nbPionsPrises = 0;
        this.monTour = Tour;
    }

    public String coup (String moulin , ArrayList listNoeuds){

        String result = "";


        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getNbPions() {
        return nbPions;
    }

    public void setNbPions(int nbPions) {
        this.nbPions = nbPions;
    }

    public int getNbMouvement() {
        return nbMouvement;
    }

    public void setNbMouvement(int nbMouvement) {
        this.nbMouvement = nbMouvement;
    }

    public int getNbPionsPrises() {
        return nbPionsPrises;
    }

    public void setNbPionsPrises(int nbPionsPrises) {
        this.nbPionsPrises = nbPionsPrises;
    }

    public int getMonTour() {
        return monTour;
    }

    public void setMonTour(int monTour) {
        this.monTour = monTour;
    }
}
