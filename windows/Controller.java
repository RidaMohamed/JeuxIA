package game.windows;

import game.Board;
import game.Mouvement;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import game.Joueur;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ImageView AImagA;
    @FXML
    private ImageView AImag2;
    @FXML
    private ImageView AImagB;
    @FXML
    private ImageView AImagD;
    @FXML
    private ImageView AImagE;
    @FXML
    private ImageView AImagF;
    @FXML
    private ImageView AImagG;
    @FXML
    private ImageView AImagH;
    @FXML
    private ImageView AImagI;
    @FXML
    private ImageView AImagJ;
    @FXML
    private ImageView AImagK;
    @FXML
    private ImageView AImagL;
    @FXML
    private ImageView AImagM;
    @FXML
    private ImageView AImagN;
    @FXML
    private ImageView AImagO;
    @FXML
    private ImageView AImagP;
    @FXML
    private ImageView AImagQ;
    @FXML
    private ImageView AImagR;
    @FXML
    private ImageView AImagS;
    @FXML
    private ImageView AImagT;
    @FXML
    private ImageView AImagU;
    @FXML
    private ImageView AImagV;
    @FXML
    private ImageView AImagW;
    @FXML
    private ImageView AImagX;

    @FXML
    private Text pionsJ1;
    @FXML
    private Text pionsJ2;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;


    public Image MoulinNoir  = new Image("game/windows/Untitled2.png");
    public Image MoulinBlanc = new Image("game/windows/Untitled1.png");
    public Image MoulinTranparant = new Image("game/windows/Untitled.png");

    private Joueur j1 ;
    private Joueur j2;
    private Board game ;
    private int etatJeux ;
    private Mouvement mouvement;
    private boolean gameRunning = true;
    String v ;

    public Controller() {

        //choisir mode de jeu
        //initialiser les joueurs machine et humaine
        //changer les fontion de moveA.......X
        //set les fontions en 2 type soit mode 1 ou mode 2
        //ecrire la fonction playVsPc()
        //set la fonton evaluate
         j1 = new Joueur("A1" , 1 , 9 ,1);
         j2 = new Joueur("A12" , 2 , 9 , 0);
         game = new game.Board(j1 , j2);
         this.etatJeux = game.isGameOver() ;


    }

    public int play (String posStr ){

        //recuperer l'etat de jeux
        this.etatJeux = game.isGameOver() ;
        boolean played = false;
        int idf = 0;

            if (game.currentPlayer().equals(j1)){
                if(j1.getNbPions() == 0){
                    if (!game.caseVide(posStr)){
                        if (j1.getEtatPrendreMoulin() == 1){
                            if (j2.rechercherMoulinJouee(posStr)){
                                j2.setLastMoulin(posStr);
                                j1.setEtatPrendreMoulin(0);
                                game.removeMoulin(posStr);
                                played = true;
                                j1.setNbPionsPrises(j1.getNbPionsPrises() + 1);
                                idf = - 1;
                            }
                        }else {
                            if (j1.rechercherMoulinJouee(posStr)){
                                game.removeMoulin(posStr);
                                j1.retirerMoulinJouee(posStr);
                                j1.setNbPions(j1.getNbPions()+1);
                                j1.setLastMoulin(posStr);
                                idf = -1 ;
                            }
                        }

                    }

                }else {
                        //ajouter moulin
                        if (j1.getEtatPrendreMoulin() == 1){
                            if (j2.rechercherMoulinJouee(posStr)){
                                j2.setLastMoulin(posStr);
                                j2.retirerMoulinJouee(posStr);
                                game.removeMoulin(posStr);
                                j1.setEtatPrendreMoulin(0);
                                played = true;
                                j1.setNbPionsPrises(j1.getNbPionsPrises() + 1);
                                idf = - 1;
                            }
                        }else {
                            if ((!j1.getLastMoulin().equals(posStr))&&(game.caseVide(posStr))){
                            game.ajouterMoulin(posStr);
                            j1.setNbPions(j1.getNbPions()-1);
                            j1.ajouterMoulinJouee(posStr);
                            //tester si il y a 3 alignees sur une meme ligne
                            played = true;
                            if (game.makeMove(posStr , j1) == 3){
                                played = false;
                                j1.setEtatPrendreMoulin(1);
                            }
                            j1.setLastMoulin(posStr);
                            idf =  j1.getIdentifiant();
                            }
                        }



                }

                if (played == true){
                    j1.setNbMouvement(j1.getNbMouvement() + 1);
                    // changer le current joueur
                        j1.setMonTour(0);
                        j2.setMonTour(1);
                    // reinitiialser l'affichage
                    this.etatJeux = game.isGameOver();
                }


            }else {

                if(j2.getNbPions() == 0){
                    if (!game.caseVide(posStr)){
                        if (j2.getEtatPrendreMoulin() == 1){
                            if (j1.rechercherMoulinJouee(posStr)){
                                j1.setLastMoulin(posStr);
                                j2.setEtatPrendreMoulin(0);
                                game.removeMoulin(posStr);
                                played = true;
                                j2.setNbPionsPrises(j2.getNbPionsPrises() + 1);
                                idf = - 1;
                            }
                        }else {
                            if (j2.rechercherMoulinJouee(posStr)){
                                game.removeMoulin(posStr);
                                j2.retirerMoulinJouee(posStr);
                                j2.setNbPions(j2.getNbPions()+1);
                                j2.setLastMoulin(posStr);
                                idf = -1 ;
                            }
                        }
                    }

                }else {
                        if (j2.getEtatPrendreMoulin() == 1){
                            if (j1.rechercherMoulinJouee(posStr)){
                                j1.setLastMoulin(posStr);
                                j1.retirerMoulinJouee(posStr);
                                game.removeMoulin(posStr);
                                j2.setEtatPrendreMoulin(0);
                                played = true;
                                j2.setNbPionsPrises(j2.getNbPionsPrises() + 1);
                                idf = - 1;
                            }
                        }else {
                            if ((!j2.getLastMoulin().equals(posStr))&&(game.caseVide(posStr))){
                            game.ajouterMoulin(posStr);
                            j2.ajouterMoulinJouee(posStr);
                            mouvement = new Mouvement(posStr , posStr);
                            j2.setNbPions(j2.getNbPions()-1);
                            played = true;
                            if (game.makeMove(posStr , j2) == 3){
                                played = false;
                                j2.setEtatPrendreMoulin(1);
                            }
                            j2.setLastMoulin(posStr);
                            idf =  j2.getIdentifiant();
                        }
                        }



                }


                if (played == true){
                    j2.setNbMouvement(j2.getNbMouvement() + 1);
                    // changer le current joueur
                    j1.setMonTour(1);
                    j2.setMonTour(0);
                    // reinitiialser l'affichage
                    this.etatJeux = game.isGameOver();

                }


            }


        if ( this.etatJeux == 1)
            System.out.println("joueur 1 a gagne");
        else if (this.etatJeux == 2)
            System.out.println("joueur 2 a gagne");
        else if (this.etatJeux == 0)
        System.out.println("matche null");

        return idf;
    }

    public int playVsPc (String posMoulin){

        return 0;
    }

    @FXML
    public void setTextPions(){
        pionsJ1.setText(String.valueOf(j1.getNbPionsPrises()));
        pionsJ2.setText(String.valueOf(j2.getNbPionsPrises()));
    }

    @FXML
    public void gameRunning (){

        if (etatJeux == -3){
            gameRunning = false;
            text2.setText("1");
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
        }else if (etatJeux == -4){
            gameRunning = false;
            text2.setText("2");
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
        }else if (etatJeux == -5){
            gameRunning = false;
            text1.setText("Match");
            text3.setText("Nul");
            text1.setVisible(true);
            //text2.setVisible(true);
            text3.setVisible(true);
        }
    }

    @FXML
    public void moveA(){

        if (gameRunning){
        System.out.println("A ");
        int i = play("A");

        if ( i== 1)
            AImagA.setImage(MoulinBlanc);
        else if (i == 2)
            AImagA.setImage(MoulinNoir);
        else if (i == -1)
            AImagA.setImage(MoulinTranparant);
        this.setTextPions();
        this.gameRunning();
        }

    }

    @FXML
    public void moveB(){

        if (gameRunning){
        System.out.println("B ");
        int i = play("B");
        if ( i== 1)
            AImagB.setImage(MoulinBlanc);
        else if (i == 2)
            AImagB.setImage(MoulinNoir);
        else if (i == -1)
            AImagB.setImage(MoulinTranparant);
        setTextPions();
            this.gameRunning();
            }
    }

    @FXML
    public void moveC(){

        if (gameRunning){
        System.out.println("C");

        int i = play("C");

        if ( i== 1)
            AImag2.setImage(MoulinBlanc);
        else if (i == 2)
            AImag2.setImage(MoulinNoir);
        else if (i == -1)
            AImag2.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();
        }

    }

    @FXML
    public void moveD(){

        if (gameRunning){
        System.out.println("D");
        int i = play("D");

        if ( i== 1)
            AImagD.setImage(MoulinBlanc);
        else if (i == 2)
            AImagD.setImage(MoulinNoir);
        else if (i == -1)
            AImagD.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();
        }

    }

    @FXML
    public void moveE(){
        if (gameRunning){
        System.out.println("E");

        int i = play("E");

        if ( i== 1)
            AImagE.setImage(MoulinBlanc);
        else if (i == 2)
            AImagE.setImage(MoulinNoir);
        else if (i == -1)
            AImagE.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }

    @FXML
    public void moveF(){

        if (gameRunning){
        System.out.println("F");

        int i = play("F");

        if ( i== 1)
            AImagF.setImage(MoulinBlanc);
        else if (i == 2)
            AImagF.setImage(MoulinNoir);
        else if (i == -1)
            AImagF.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }

    @FXML
    public void moveG(){
        if (gameRunning){
        System.out.println("G");

        int i = play("G");

        if ( i== 1)
            AImagG.setImage(MoulinBlanc);
        else if (i == 2)
            AImagG.setImage(MoulinNoir);
        else if (i == -1)
            AImagG.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }

    @FXML
    public void moveH(){

        if (gameRunning){
        System.out.println("H");

        int i = play("H");

        if ( i== 1)
            AImagH.setImage(MoulinBlanc);
        else if (i == 2)
            AImagH.setImage(MoulinNoir);
        else if (i == -1)
            AImagH.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }

    @FXML
    public void moveI(){

        if (gameRunning){
        System.out.println("I");

        int i = play("I");

        if ( i== 1)
            AImagI.setImage(MoulinBlanc);
        else if (i == 2)
            AImagI.setImage(MoulinNoir);
        else if (i == -1)
            AImagI.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveJ(){
        if (gameRunning){
        System.out.println("J");

        int i = play("J");

        if ( i== 1)
            AImagJ.setImage(MoulinBlanc);
        else if (i == 2)
            AImagJ.setImage(MoulinNoir);
        else if (i == -1)
            AImagJ.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}

    }
    @FXML
    public void moveK(){
         if (gameRunning){
        System.out.println("K");

        int i = play("K");

        if ( i== 1)
            AImagK.setImage(MoulinBlanc);
        else if (i == 2)
            AImagK.setImage(MoulinNoir);
        else if (i == -1)
            AImagK.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveL(){

         if (gameRunning){
        System.out.println("L");

        int i = play("L");

        if ( i== 1)
            AImagL.setImage(MoulinBlanc);
        else if (i == 2)
            AImagL.setImage(MoulinNoir);
        else if (i == -1)
            AImagL.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveM(){

        if (gameRunning){
        System.out.println("M");
        int i = play("M");

        if ( i== 1)
            AImagM.setImage(MoulinBlanc);
        else if (i == 2)
            AImagM.setImage(MoulinNoir);
        else if (i == -1)
            AImagM.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveN(){

         if (gameRunning){
        System.out.println("N");

        int i = play("N");

        if ( i== 1)
            AImagN.setImage(MoulinBlanc);
        else if (i == 2)
            AImagN.setImage(MoulinNoir);
        else if (i == -1)
            AImagN.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveO(){

         if (gameRunning){
        System.out.println("O");

        int i = play("O");

        if ( i== 1)
            AImagO.setImage(MoulinBlanc);
        else if (i == 2)
            AImagO.setImage(MoulinNoir);
        else if (i == -1)
            AImagO.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveP(){
         if (gameRunning){
        System.out.println("P");

        int i = play("P");

        if ( i== 1)
            AImagP.setImage(MoulinBlanc);
        else if (i == 2)
            AImagP.setImage(MoulinNoir);
        else if (i == -1)
            AImagP.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveQ(){

        if (gameRunning){
        System.out.println("Q");

        int i = play("Q");

        if ( i== 1)
            AImagQ.setImage(MoulinBlanc);
        else if (i == 2)
            AImagQ.setImage(MoulinNoir);
        else if (i == -1)
            AImagQ.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveR(){
        if (gameRunning){
        System.out.println("R");

        int i = play("R");

        if ( i== 1)
            AImagR.setImage(MoulinBlanc);
        else if (i == 2)
            AImagR.setImage(MoulinNoir);
        else if (i == -1)
            AImagR.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveS(){

          if (gameRunning){
        System.out.println("S");

        int i = play("S");

        if ( i== 1)
            AImagS.setImage(MoulinBlanc);
        else if (i == 2)
            AImagS.setImage(MoulinNoir);
        else if (i == -1)
            AImagS.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveT(){

        if (gameRunning){
        System.out.println("T");

        int i = play("T");

        if ( i== 1)
            AImagT.setImage(MoulinBlanc);
        else if (i == 2)
            AImagT.setImage(MoulinNoir);
        else if (i == -1)
            AImagT.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveU(){

        if (gameRunning){
        System.out.println("U");

        int i = play("U");

        if ( i== 1)
            AImagU.setImage(MoulinBlanc);
        else if (i == 2)
            AImagU.setImage(MoulinNoir);
        else if (i == -1)
            AImagU.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveV(){

        if (gameRunning){
        System.out.println("V");

        int i = play("V");

        if ( i== 1)
            AImagV.setImage(MoulinBlanc);
        else if (i == 2)
            AImagV.setImage(MoulinNoir);
        else if (i == -1)
            AImagV.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveW(){

         if (gameRunning){
        System.out.println("W");

        int i = play("W");

        if ( i== 1)
            AImagW.setImage(MoulinBlanc);
        else if (i == 2)
            AImagW.setImage(MoulinNoir);
        else if (i == -1)
            AImagW.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }
    @FXML
    public void moveX(){

        if (gameRunning){
        System.out.println("X");

        int i = play("X");

        if ( i== 1)
            AImagX.setImage(MoulinBlanc);
        else if (i == 2)
            AImagX.setImage(MoulinNoir);
        else if (i == -1)
            AImagX.setImage(MoulinTranparant);
        setTextPions();
        this.gameRunning();}
    }

}
