package game.etat;

public class Connection {

    protected String FromNode ;
    protected String ToNode ;
    protected int cost;

    public Connection(String fromNode, String toNode, int cost) {
        this.FromNode = fromNode;
        this.ToNode = toNode;
        this.cost = cost;
    }

    public int getCost (){
        return this.cost;
    }

    public String getFromNode (){
        return this.FromNode;
    }

    public String getToNode (){
        return this.ToNode;
    }


}
