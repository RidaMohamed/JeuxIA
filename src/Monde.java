public class Monde {

    public static void main(String[]args){

        Joueur j1 = new Joueur("A1" , 1 , 12 ,1);
        Joueur j2 = new Joueur("A12" , 2 , 12 , 0);

        Board game = new Board(j1 , j2);
        int i = game.isGameOver() ;
        //afficher letat initiale de jeu

        while( i == -1){
            if (game.currentPlayer().equals(j1)){
                //demander mouvement
                //ajouter mouvment a letat
                // changer le current joueur
                // reinitiialser l'affichage
            }else {
                //demander mouvement
                //ajouter mouvment a letat
                // changer le current joueur
                // reinitiialser l'affichage
            }
        }


       if ( i == 1)
           System.out.println("joueur 1 a gagne");
       else if (i == 2)
           System.out.println("joueur 2 a gagne");
       else
           System.out.println("matche null");


//        etat.Graph graphJeux = new etat.Graph();

    }


}
