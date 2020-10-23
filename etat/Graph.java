package game.etat;

import java.util.ArrayList;
import java.util.Stack;

public class Graph
{

    protected ArrayList<Connection> listMoulinConnection ;
    protected ArrayList<String> listMoulin ;
    private int i = 64 ;



    public Graph() {
        this.listMoulinConnection = new ArrayList<Connection>();
        this.listMoulinConnection.add(new Connection("A","B",1));
        this.listMoulinConnection.add(new Connection("A","J",4));
        this.listMoulinConnection.add(new Connection("B","C",1));
        this.listMoulinConnection.add(new Connection("B","E",13));
        this.listMoulinConnection.add(new Connection("C","O",2));
        this.listMoulinConnection.add(new Connection("J","V",4));
        this.listMoulinConnection.add(new Connection("V","W",3));
        this.listMoulinConnection.add(new Connection("W","X",3));
        this.listMoulinConnection.add(new Connection("X","O",2));
        this.listMoulinConnection.add(new Connection("O","N",14));
        this.listMoulinConnection.add(new Connection("N","U",6));
        this.listMoulinConnection.add(new Connection("U","T",7));
        this.listMoulinConnection.add(new Connection("T","S",7));
        this.listMoulinConnection.add(new Connection("S","K",8));
        this.listMoulinConnection.add(new Connection("K","D",8));
        this.listMoulinConnection.add(new Connection("D","E",5));
        this.listMoulinConnection.add(new Connection("E","F",5));
        this.listMoulinConnection.add(new Connection("F","N",6));
        this.listMoulinConnection.add(new Connection("N","M",14));
        this.listMoulinConnection.add(new Connection("M","R",10));
        this.listMoulinConnection.add(new Connection("R","Q",11));
        this.listMoulinConnection.add(new Connection("Q","P",11));
        this.listMoulinConnection.add(new Connection("P","L",12));
        this.listMoulinConnection.add(new Connection("L","G",12));
        this.listMoulinConnection.add(new Connection("G","H",9));
        this.listMoulinConnection.add(new Connection("H","I",9));
        this.listMoulinConnection.add(new Connection("I","M",10));
        this.listMoulinConnection.add(new Connection("E","H",13));
        this.listMoulinConnection.add(new Connection("W","T",15));
        this.listMoulinConnection.add(new Connection("T","Q",15));
        this.listMoulinConnection.add(new Connection("J","K",16));
        this.listMoulinConnection.add(new Connection("K","L",16));

        listMoulin = new ArrayList<>();

        for (int j = 0 ; j < 24 ; j ++){
            i++;
            listMoulin.add(String.valueOf((char) i));
        }

    }

    public Stack getConnection(String node){

        Stack<Connection> listConnexions = new Stack<Connection>();
        for (int i = 0 ; i< listMoulinConnection.size() ; i ++ ){
            if ((listMoulinConnection.get(i).FromNode == node)
                 || (listMoulinConnection.get(i).ToNode == node)){
                listConnexions.add(listMoulinConnection.get(i));
            }
        }

        return listConnexions;
    }

    public ArrayList<String> getListMoulin() {
        return listMoulin;
    }

    public void ajouterConnection(Connection c){
        listMoulinConnection.add(c);
    }

}
