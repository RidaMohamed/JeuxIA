public class Joueur {

    private String name ;
    private int identifiant;
    private int nbMouvment;

    public Joueur(String name, int identifiant, int nbMouvment) {
        this.name = name;
        this.identifiant = identifiant;
        this.nbMouvment = nbMouvment;
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

    public int getNbMouvment() {
        return nbMouvment;
    }

    public void setNbMouvment(int nbMouvment) {
        this.nbMouvment = nbMouvment;
    }
}
