import windows.TableDeJeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Monde {

    public static void main(String[]args){

        Joueur j1 = new Joueur("A1" , 1 , 9 ,1);
        Joueur j2 = new Joueur("A12" , 2 , 9 , 0);

        Board game = new Board(j1 , j2);
        int i = game.isGameOver() ;
        Scanner midi = new Scanner(System.in);
        System.out.println("Bienvenue ");

        //afficher letat initiale de jeu
        TableDeJeu fenetreDeJeu = new TableDeJeu();



        while( i == -1){
            if (game.currentPlayer().equals(j1)){
                System.out.println("C'est le tour de Joueur 1");
                Mouvement mouvement = null;
                String str = "";
                String str2 = "";


                //demander mouvement
                if (j1.getNbPions() == 8){

                    str = midi.next();
                    str2 = midi.next();
                    mouvement = new Mouvement(str , str2);

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        System.out.println("Mouvement invalide");
                        str = midi.next();
                        str2 = midi.next();
                        mouvement = new Mouvement(str , str2);
                    }

                    j1.setNbMouvement(j1.getNbMouvement() + 1);

                }
                else {

                    str = midi.next();
                    mouvement = new Mouvement(str , "");

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        str = midi.next();
                        mouvement = new Mouvement(str , "");
                    }

                    j1.setNbPions(j1.getNbPions()-1);
                    j1.setNbMouvement(j1.getNbMouvement() + 1);

                }

                // changer le current joueur
                j1.setMonTour(0);
                j2.setMonTour(1);

                // reinitiialser l'affichage

                i = game.isGameOver();

            }else {
                System.out.println("C'est le tour de Joueur 2");
                Mouvement mouvement = null;
                String str = "";
                String str2 = "";


                //demander mouvement
                if (j2.getNbPions() == 8){

                    str = midi.next();
                    str2 = midi.next();
                    mouvement = new Mouvement(str , str2);

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        System.out.println("Mouvement invalide");
                        str = midi.next();
                        str2 = midi.next();
                        mouvement = new Mouvement(str , str2);
                    }

                    j2.setNbMouvement(j2.getNbMouvement() + 1);

                }
                else {

                    str = midi.next();
                    mouvement = new Mouvement(str , "");

                    //ajouter mouvment a letat
                    while(game.makeMove(mouvement) != 0){
                        str = midi.next();
                        mouvement = new Mouvement(str , "");
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


        if ( i == 1)
            System.out.println("joueur 1 a gagne");
        else if (i == 2)
            System.out.println("joueur 2 a gagne");
        else
            System.out.println("matche null");


    }


}