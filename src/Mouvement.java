public class Mouvement {

    public String FromNode ;
    public String ToNode;

    public Mouvement(String fromNode, String toNode) {
        FromNode = fromNode;
        ToNode = toNode;
    }

    public String getFromNode() {
        return FromNode;
    }

    public void setFromNode(String fromNode) {
        FromNode = fromNode;
    }

    public String getToNode() {
        return ToNode;
    }

    public void setToNode(String toNode) {
        ToNode = toNode;
    }
}
