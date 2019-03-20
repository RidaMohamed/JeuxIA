package game;

import java.util.ArrayList;

public class Joueur {

    private String name ;
    private int identifiant;
    private int nbPions;
    private int nbMouvement;
    private int nbPionsPrises;
    private ArrayList<String> listMoulinJouee ;
    private int monTour ;
    private int etatPrendreMoulin = 0;// 1 cad c'est le tour de ce joueur 0 non
    private String LastMoulin ;

    public Joueur(String name, int identifiant, int nbPions , int Tour) {
        this.name = name;
        this.identifiant = identifiant;
        this.nbPions = nbPions;
        this.nbMouvement = 0;
        this.nbPionsPrises = 0;
        this.monTour = Tour;
        this.listMoulinJouee = new ArrayList<String>();
        this.LastMoulin = "";
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

    public void ajouterMoulinJouee(String MoulinJouee) {
        this.listMoulinJouee.add(MoulinJouee) ;
    }

    public void retirerMoulinJouee(String MoulinJouee) {
        this.listMoulinJouee.remove(MoulinJouee) ;
    }

    public boolean rechercherMoulinJouee(String MoulinJouee) {
        boolean b = false;
        for (int i = 0 ; i < this.listMoulinJouee.size() ; i++){
            if (this.listMoulinJouee.get(i).equals(MoulinJouee))
                b = true;
        }
        return b;
    }

    public int getEtatPrendreMoulin() {
        return etatPrendreMoulin;
    }

    public void setEtatPrendreMoulin(int etatPrendreMoulin) {
        this.etatPrendreMoulin = etatPrendreMoulin;
    }

    public String getLastMoulin() {
        return LastMoulin;
    }

    public void setLastMoulin(String lastMoulin) {
        LastMoulin = lastMoulin;
    }

    public ArrayList<String> getListMoulinJouee() {
        return listMoulinJouee;
    }
}
