package game;

import game.etat.Connection;
import game.etat.Graph;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class Board {

    protected ArrayList<Mouvement> listmouvement ;
    protected Joueur joueur1 ;
    protected Joueur joueur2 ;
    protected Graph graph ;
    protected ArrayList<String> listMoulin ;
    protected ArrayList<String> ListMoulinJouees;


    public Board(Joueur j1 , Joueur j2) {

        listmouvement = new ArrayList<Mouvement>();
        this.joueur1 = j1;
        this.joueur2 = j2;
        graph = new Graph();
        listMoulin = new ArrayList<String>();

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
     * @param
     */
    public int makeMove(String posMOmouluin , Joueur joueur){

        int j = 1;
        int i ;
        ArrayList<Integer> ls = new ArrayList<>();
        int i2;
        Stack<Connection> list = graph.getConnection(posMOmouluin);


        while (!list.isEmpty()){
            Connection c = list.peek();
            i = c.getCost();
            if ((ls.size()!=0)&&(ls.get(0) != i)&&(j==2))
                j--;
            ls.add(i);

            //System.out.println(c.getFromNode() + " " + c.getToNode() + " " + c.getCost());

            if (c.getFromNode().equals(posMOmouluin)){
                //on travail avec ToNode
                if (joueur.rechercherMoulinJouee(c.getToNode())){
                    //on trouve un deuxieme moulin de meme couleur
                    j++;
                    Stack<Connection> list2 = graph.getConnection(c.getToNode());

                    while (!list2.isEmpty()){
                        Connection c2 = list2.peek();
                        i2 = c2.getCost();

                        if (i2 == i){
                            if (c2.getFromNode().equals(c.getToNode())){
                                //on travail avec ToNode
                                if (joueur.rechercherMoulinJouee(c2.getToNode()) &&
                                    !c2.getToNode().equals(c.getFromNode())){
                                    j ++;
                                    list.removeAllElements();
                                    list2.removeAllElements();

                                }else{
                                    list2.remove(c2);
                                    list.remove(c);
                                }

                            }else {
                                //on travail avec FromNode
                                if (joueur.rechercherMoulinJouee(c2.getFromNode()) &&
                                    !c2.getFromNode().equals(c.getFromNode())){
                                    j++;
                                    list.removeAllElements();
                                    list2.removeAllElements();
                                }else {
                                    list2.remove(c2);
                                    list.remove(c);
                                }
                            }

                        }else {
                            list2.remove(c2);
                            list.remove(c);
                        }

                    }
                    list2.removeAllElements();
                }else {
                    list.remove(c);
                }

            }else {
                //on travail avec fromNode
                if (joueur.rechercherMoulinJouee(c.getFromNode())){
                    //on trouve un 2 moulin de meme couleur
                    j++;
                    Stack<Connection> list2 = graph.getConnection(c.getFromNode());

                    while (!list2.isEmpty()){
                        Connection c2 = list2.peek();
                        i2 = c2.getCost();

                        if (i2 == i){
                            if (c2.getFromNode().equals(c.getFromNode())){
                                //on travail avec ToNode
                                if (joueur.rechercherMoulinJouee(c2.getToNode()) &&
                                    !c2.getToNode().equals(c.getToNode())){
                                    j ++;
                                    list.removeAllElements();
                                    list2.removeAllElements();
                                }else{
                                    list2.remove(c2);
                                }

                            }else {
                                //on travail avec FromNode
                                if (joueur.rechercherMoulinJouee(c2.getFromNode()) &&
                                    !c2.getFromNode().equals(c.getToNode())){
                                    j++;
                                    list.removeAllElements();
                                    list2.removeAllElements();
                                }else {
                                    list2.remove(c2);
                                    list.remove(c);
                                }
                            }


                        }else {
                            list2.remove(c2);
                            list.remove(c);
                        }

                    }

                    list2.removeAllElements();
                }else {
                    list.remove(c);
                }

            }

        }



        return j;

    }


    public int evaluate(String a ,String b, String c){


        ////////////////////////////////////////////
        HashMap<String , Integer> listetatnegatif = new HashMap<>();//METRE EN HASH MAP C MIEUX
        HashMap<String , Integer> listetatpositif = new HashMap<>();//METRE EN HASH MAP C MIEUX
        ArrayList<String> listetatneutre = new ArrayList<>();

        //parcourire toutes les sommets
        this.listMoulin = graph.getListMoulin();
        for (int i = 0 ; i < 24 ; i++) {
            //recuperer le premier sommet
            String pigon = listMoulin.get(i);
            if(!this.ListMoulinJouees.contains(pigon)){

                //cas le case est vide
                //recuperer tooutes les cases vides
                Stack<Connection> list = graph.getConnection(pigon);

            int  u = 10;
            while (!list.empty()){
                //retirer le premier element
                Connection connection = list.peek();
                //recuperer le cost de l'arret
                int y = connection.getCost();

                if(connection.getFromNode().equals(pigon)){
                    //on travail avec le go to node
                    if (this.ListMoulinJouees.contains(connection.getToNode())){
                        if (joueur2.rechercherMoulinJouee(connection.getToNode())){
                            //recuperer toutes les connections de node
                            Stack<Connection> list2 = graph.getConnection(connection.getToNode());
                            while (!list2.empty()){
                                Connection connection1 = list2.peek();
                                if (!connection.equals(connection1)){
                                    if (y == connection1.getCost() ){
                                        if (connection1.getFromNode().equals(connection.getToNode())){
                                            if (this.ListMoulinJouees.contains(connection1.getToNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getToNode())){
                                                    u = 2 ;
                                                    list2.remove(connection1);
                                                }else {
                                                    if (u==10)
                                                    u = 0 ;
                                                    list2.remove(connection1);
                                                }
                                            }else {
                                               
                                            }
                                        }else{
                                            if (this.ListMoulinJouees.contains(connection1.getFromNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getFromNode())){
                                                    u = 2 ;
                                                    list2.remove(connection1);
                                                }else {
                                                    if (u==10)
                                                        u = 0 ;
                                                    list2.remove(connection1);
                                                }
                                            }else {

                                            }
                                        }

                                    }else {
                                        list2.remove(connection1);
                                    }

                                }else{
                                    list2.remove(connection1);
                                }
                            }
                        }else {
                            //recuperer toutes les connections de node
                            Stack<Connection> list2 = graph.getConnection(connection.getToNode());

                            while (!list2.empty()){
                                Connection connection1 = list2.peek();
                                if (!connection.equals(connection1)){
                                    //verifier que l'objet connection n'existe pas
                                    if (y == connection1.getCost() ){
                                        if (connection1.getFromNode().equals(connection.getToNode())){
                                            if (this.ListMoulinJouees.contains(connection1.getToNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getToNode())){
                                                    if (u == 10)
                                                        u =0;
                                                    list2.remove(connection1);
                                                }else {
                                                    listetatnegatif.put(pigon , -2);
                                                    list2.removeAllElements();
                                                    list.removeAllElements();
                                                }
                                            }else {
                                                if (u == 10)
                                                    u =0;
                                                list2.remove(connection1);
                                            }
                                        }else {
                                            if (this.ListMoulinJouees.contains(connection1.getFromNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getFromNode())){
                                                    if (u == 10)
                                                        u =0;
                                                    list2.remove(connection1);
                                                }else {
                                                    listetatnegatif.put(pigon , -2);
                                                    list2.removeAllElements();
                                                    list.removeAllElements();
                                                }
                                            }else {
                                                if (u == 10)
                                                    u =0;
                                                list2.remove(connection1);
                                            }
                                        }
                                    }else {
                                        list2.remove(connection1);
                                    }
                                }else {
                                    list2.remove(connection1);
                                }

                            }
                        }
                    }else {
                        //ajouter
                        if (u == 10)
                        u = 0 ;
                        list.remove(connection);
                    }
                }else {
                    //on travail avec le from node
                    if (this.ListMoulinJouees.contains(connection.getFromNode())){
                        if (joueur2.rechercherMoulinJouee(connection.getFromNode())){

                            //recuperer toutes les connections de node
                            Stack<Connection> list2 = graph.getConnection(connection.getFromNode());
                            while (!list2.empty()){
                                Connection connection1 = list2.peek();
                                if (!connection.equals(connection1)){
                                    if (y == connection1.getCost() ){
                                        if (connection1.getFromNode().equals(connection.getFromNode())){
                                            if (this.ListMoulinJouees.contains(connection1.getToNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getToNode())){
                                                    u = 2 ;
                                                    list2.remove(connection1);
                                                }else {
                                                    if (u==10)
                                                        u = 0 ;
                                                    list2.remove(connection1);
                                                }
                                            }else {

                                            }
                                        }else{
                                            if (this.ListMoulinJouees.contains(connection1.getFromNode())){
                                                if (joueur2.rechercherMoulinJouee(connection1.getFromNode())){
                                                    u = 2 ;
                                                    list2.remove(connection1);
                                                }else {
                                                    if (u==10)
                                                        u = 0 ;
                                                    list2.remove(connection1);
                                                }
                                            }else {

                                            }
                                        }
                                    }else {
                                        list2.remove(connection1);
                                    }
                                }else{
                                    list2.remove(connection1);
                                }
                            }
                        }else {
                            //
                            Stack<Connection> list2 = graph.getConnection(connection.getFromNode());

                            while (!list2.empty()){
                                Connection connection1 = list2.peek();
                                if (y == connection1.getCost()){
                                    if (connection1.getFromNode().equals(connection.getFromNode())){
                                        if (this.ListMoulinJouees.contains(connection1.getToNode())){
                                            if (joueur2.rechercherMoulinJouee(connection1.getToNode())){
                                                if (u == 10)
                                                    u =0;
                                                list2.remove(connection1);
                                            }else {
                                                listetatnegatif.put(pigon , -2);
                                                list2.removeAllElements();
                                                list.removeAllElements();
                                            }
                                        }else {
                                            if (u == 10)
                                                u =0;
                                            list2.remove(connection1);
                                        }
                                    }else {
                                        if (this.ListMoulinJouees.contains(connection1.getFromNode())){
                                            if (joueur2.rechercherMoulinJouee(connection1.getFromNode())){
                                                if (u == 10)
                                                    u =0;
                                                list2.remove(connection1);
                                            }else {
                                                listetatnegatif.put(pigon , -2);
                                                list2.removeAllElements();
                                                list.removeAllElements();
                                            }
                                        }else {
                                            if (u == 10)
                                                u =0;
                                            list2.remove(connection1);
                                        }
                                    }
                                }else {
                                    list2.remove(connection1);
                                }
                            }
                        }
                    }else {
                        //ajouter
                        if (u == 10)
                        u = 0 ;
                        list.remove(connection);
                    }
                }
            }

            ///////////

        }
                ///////
        }
        /////

        ///////////////////////////////////////////////

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

        int etat = -2;//non terminé

        if(joueur1.getNbPionsPrises() == 7)
            etat= -3;//joueur 1 a gagné
        else if (joueur2.getNbPionsPrises() == 7)
            etat= -4;//joueur 2 a gagné
        else if ((joueur1.getNbMouvement() == 50) && (joueur1.getNbPionsPrises() == 0)
                &&(joueur2.getNbMouvement() == 50) && (joueur2.getNbPionsPrises() == 0))
            etat= -5;//partie null
        // retse 2 cas

        return etat;

    }


    public boolean caseVide(String moulin){

        boolean b = true;

        for (int i = 0; i <this.listMoulin.size();i++){
            if (this.listMoulin.get(i).equals(moulin))
                b=false;
        }

        return b;

    }

    public void ajouterMoulin(String moulin){
        this.listMoulin.add(moulin);
    }

    public void removeMoulin(String moulin){
        this.listMoulin.remove(moulin);
    }

}