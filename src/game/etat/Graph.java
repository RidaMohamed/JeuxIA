package game.etat;

import java.util.ArrayList;

public class Graph
{

    protected ArrayList<Connection> listMoulinConnection ;
    protected ArrayList<String> listMoulin ;


    public Graph() {
        listMoulinConnection = new ArrayList<Connection>();
        for(int  i = 0 ; i < 24 ; i++){
        }

    }

    public ArrayList getConnection(String node){

        ArrayList<String> listConnexions = new ArrayList<>();
        for (int i = 0 ; i< listMoulinConnection.size() ; i ++ ){
            if (listMoulinConnection.get(i).FromNode == node){
                listConnexions.add(listMoulinConnection.get(i).ToNode);
            }
        }

        return listConnexions;
    }

    public void ajouterConnection(Connection c){
        listMoulinConnection.add(c);
    }

}
