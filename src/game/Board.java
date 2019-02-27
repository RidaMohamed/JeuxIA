package game;

import game.etat.Connection;
import game.etat.Graph;

import java.util.ArrayList;


public class Board {

    protected ArrayList<Mouvement> listmouvement ;
    protected Joueur joueur1 ;
    protected Joueur joueur2 ;
    protected Graph graph ;


    public Board(Joueur j1 , Joueur j2) {

        listmouvement = new ArrayList<Mouvement>();
        this.joueur1 = j1;
        this.joueur2 = j2;
        graph = new Graph();


    }

    /** la fonctio qui
     * @return tous les mouvement jouer par les 2
     * joueurs
     */
    public ArrayList getMoves(){

        return listmouvement;
    }


    /**
     * la fonction qui enrigistre un mouvement jouer oar un des
     * joueur
     * @param mouvement
     */
    public int makeMove(Mouvement mouvement){

        //liste de tous les connections pour savoir si
        //un mouvement existe deja
        ArrayList<Connection> liste = new ArrayList<Connection>();
        liste =graph.getConnection(mouvement.FromNode);
        int j = 0;

        //verifier si  un mouvement existe
        for (int i = 0 ; i< liste.size() ; i++){
            if (liste.get(i).getToNode() == mouvement.ToNode){
                j = -1;
            }
        }

        if ( j != -1){
            //ca set a rien tous les 2 ensembles
            //maybe its bettr to remove listemouvement
            Connection c = new Connection(mouvement.FromNode , mouvement.ToNode , 1);
            listmouvement.add(mouvement);
            return j ;
        }else{
            //mouvement deja existant (-1)
            return  j ;
        }


    }


    public int evaluate(){
        return 0;
    }

    /**
     * la fonction qui
     * @return le joueur current
     */
    public Joueur currentPlayer(){
        if (joueur1.getMonTour() == 1)
            return joueur1;
        else
            return joueur2;

    }

    /**
     * la fonction qui est ce que c'est termine
     * ou non , si oui elle retourne le joueur qui a gagne
     * (1 cad le joeur1 , 2 cad le joueur2 ) , 0 cad un matche null
     * @return
     */
    public int isGameOver(){

        int etat = -1;//non terminé

        if(joueur1.getNbPionsPrises() == 7)
            etat= 1;//joueur 1 a gagné
        else if (joueur2.getNbPionsPrises() == 7)
            etat= 2;//joueur 2 a gagné
        else if ((joueur1.getNbMouvement() == 50) && (joueur1.getNbPionsPrises() == 0)
                &&(joueur2.getNbMouvement() == 50) && (joueur2.getNbPionsPrises() == 0))
            etat= 1;//partie null
        // retse 2 cas

        return etat;

    }

}