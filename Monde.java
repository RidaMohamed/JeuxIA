package game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Monde extends Application {

    public static void main(String[]args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/game/windows/menu/Menu.fxml"));
        primaryStage.setTitle("Jeux de game.Moulin");
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();

    }



        /*


        //afficher letat initiale de jeu


        while( i == -1){
            if (game.currentPlayer().equals(j1)){
                System.out.println("C'est le tour de game.Joueur 1");
                game.Mouvement mouvement = null;
                String str = "";
                String str2 = "";


                //demander mouvement
                if (j1.getNbPions() == 8){

                    str = midi.next();
                    str2 = midi.next();
                    mouvement = new game.Mouvement(str , str2);

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        System.out.println("game.Mouvement invalide");
                        str = midi.next();
                        str2 = midi.next();
                        mouvement = new game.Mouvement(str , str2);
                    }

                    j1.setNbMouvement(j1.getNbMouvement() + 1);

                }
                else {

                    str = midi.next();
                    mouvement = new game.Mouvement(str , "");

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        str = midi.next();
                        mouvement = new game.Mouvement(str , "");
                    }

                    j1.setNbPions(j1.getNbPions()-1);
                    j1.setNbMouvement(j1.getNbMouvement() + 1);

                }

            }else {
                System.out.println("C'est le tour de game.Joueur 2");
                game.Mouvement mouvement = null;
                String str = "";
                String str2 = "";


                //demander mouvement
                if (j2.getNbPions() == 8){

                    str = midi.next();
                    str2 = midi.next();
                    mouvement = new game.Mouvement(str , str2);

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        System.out.println("game.Mouvement invalide");
                        str = midi.next();
                        str2 = midi.next();
                        mouvement = new game.Mouvement(str , str2);
                    }

                    j2.setNbMouvement(j2.getNbMouvement() + 1);

                }
                else {

                    str = midi.next();
                    mouvement = new game.Mouvement(str , "");

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        str = midi.next();
                        mouvement = new game.Mouvement(str , "");
                    }

                    j2.setNbPions(j2.getNbPions()-1);
                    j2.setNbMouvement(j2.getNbMouvement() + 1);

                }

                // changer le current joueur
                j1.setMonTour(1);
                j2.setMonTour(0);

                // reinitiialser l'affichage

                i = game.isGameOver();

            }
        }



*/





}
