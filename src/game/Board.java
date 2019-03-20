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
            if(this.ListMoulinJouees.contains(pigon)){
                //cas ou le pigon choisit est present aur la table
                if (joueur2.rechercherMoulinJouee(pigon)){
                    //ce pigon appertiant au machine
                    Stack<Connection> list = graph.getConnection(pigon);
                    Connection connection = list.peek();
                    if (connection.getFromNode().equals(pigon)){
                        //on regarde le to node
                        if (this.ListMoulinJouees.contains(connection.getToNode())){
                            //case non vide
                            if (joueur2.rechercherMoulinJouee(connection.getToNode())){
                                //un autre pigon pour lejoueur machine
                                //donc le cas est classe comme favoris
                                listetatpositif.put(pigon , 2 );
                            }else{
                                //pigon de l'autre joueur
                                //cas non dicider encors
                                list.remove(connection);
                            }

                        }else {
                            //case vide
                            listetatpositif.put(pigon , 1);
                        }
                    }else {
                        //on regarde le from node
                    }
                }else {
                    //ce pigon appertiant au humaine
                    Stack<Connection> list = graph.getConnection(pigon);
                    Connection connection = list.peek();
                    if (connection.getFromNode().equals(pigon)){
                        //on regarde le to node
                        if (this.ListMoulinJouees.contains(connection.getToNode())){
                            //case non vide
                            if (joueur2.rechercherMoulinJouee(connection.getToNode())){
                                //un autre pigon pour lejoueur machine
                                //donc le cas est classe comme favoris
                                listetatpositif.put(pigon , 2 );
                            }else{
                                //pigon de l'autre joueur humaine
                                //cas non favoris pour la mchaine
                                listetatnegatif.put(pigon , -2);
                            }

                        }else {
                            //case vide
                            //faite un deuoeme parcours

                        }
                    }else {
                        //on regarde le from node
                    }

                }

            }else {
                //cas le case est vide
                Stack<Connection> list = graph.getConnection(pigon);
                int  u = 10;
                while (!list.empty()){

                    Connection connection = list.peek();
                    int y = connection.getCost();
                    if(connection.getFromNode().equals(pigon)){
                        if (this.ListMoulinJouees.contains(pigon)){
                            if (joueur2.rechercherMoulinJouee(connection.getToNode())){

                            }else {
                                Stack<Connection> list2 = graph.getConnection(connection.getToNode());
                                while (!list2.empty()){
                                    Connection connection1 = list2.peek();
                                    if (y == connection1.getCost()){
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
                                }
                            }
                        }else {
                            //ajouter
                            u = 0 ;
                            list.remove(connection);
                        }
                    }else {
                        if (this.ListMoulinJouees.contains(pigon)){
                            if (joueur2.rechercherMoulinJouee(connection.getFromNode())){

                            }else {
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
                            u = 0 ;
                            list.remove(connection);
                        }
                    }
                }

            }
        }

        ///////////////////////////////////////////////
        Stack<Connection> list = graph.getConnection(a);
        while (!list.empty()){
            Connection connection = list.pop();
            int i = list.size() - 1 ;
            if (connection.getFromNode().equals(a)){

                if (!joueur1.rechercherMoulinJouee(connection.getToNode()) &&
                    !joueur2.rechercherMoulinJouee(connection.getToNode())){
                    joueur2.ajouterMoulinJouee(connection.getToNode());
                    list.removeAllElements();
                }else {
                    System.out.println(list.size());
                    list.addAll(graph.getConnection(connection.getToNode()));
                    list.remove(i);
                    System.out.println(list.size());
                }

            }else{

                if (!joueur1.rechercherMoulinJouee(connection.getFromNode())&&
                        !joueur2.rechercherMoulinJouee(connection.getToNode())){
                    joueur2.ajouterMoulinJouee(connection.getFromNode());
                    list.removeAllElements();
                }else {
                    System.out.println(list.size());
                    list.addAll(graph.getConnection(connection.getFromNode()));
                    list.addAll(graph.getConnection(connection.getFromNode()));System.out.println(list.size());

                    list.remove(i);
                }
            }
        }
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