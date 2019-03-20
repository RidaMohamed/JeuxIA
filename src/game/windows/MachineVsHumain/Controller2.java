package game.windows.MachineVsHumain;

import game.Board;
import game.Joueur;
import game.Mouvement;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.text.BreakIterator;

public class Controller2 {


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
    private Board  game ;
    private int    etatJeux ;
    private Mouvement mouvement;
    private boolean   gameRunning = true;
    private String    v ;

    public Controller2() {

        //initialiser les joueurs machine et humaine
        //changer les fontion de moveA.......X
        //set les fontions en 2 type soit mode 1 ou mode 2
        //ecrire la fonction playVsPc()
        //set la fonton evaluate
        j1 = new Joueur("A1" , 1 , 9 ,1);
        j2 = new Joueur("PC2" , 2 , 9 , 0);
        game = new game.Board(j1 , j2);
        this.etatJeux = game.isGameOver() ;
    }

    public int play (String posStr ){

        //recuperer l'etat de jeux
        this.etatJeux = game.isGameOver() ;
        boolean played = false;
        int idf = 0;


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
                if (this.etatJeux != -1){
                    j1.setMonTour(1);
                    j2.setMonTour(0);
                    game.evaluate(posStr  , "Z"  , "Z");
                }

            }

            //tester si le jeux est termine


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
    public void reinitializerVue(){

        for (int i = 0 ; i < j1.getListMoulinJouee().size() ; i++){
            switch (j1.getListMoulinJouee().get(i)){
                case "A" :
                    AImagA.setImage(MoulinBlanc);
                    break;
                case "B" :
                    AImagB.setImage(MoulinBlanc);
                    break;
                case "C" :
                    AImag2.setImage(MoulinBlanc);
                    break;
                case "D" :
                    AImagD.setImage(MoulinBlanc);
                    break;
                case "E" :
                    AImagE.setImage(MoulinBlanc);
                    break;
                case "F" :
                    AImagF.setImage(MoulinBlanc);
                    break;
                case "G" :
                    AImagG.setImage(MoulinBlanc);
                    break;
                case "H" :
                    AImagH.setImage(MoulinBlanc);
                    break;
                case "I" :
                    AImagI.setImage(MoulinBlanc);
                    break;
                case "J" :
                    AImagJ.setImage(MoulinBlanc);
                    break;
                case "K" :
                    AImagK.setImage(MoulinBlanc);
                    break;
                case "L" :
                    AImagL.setImage(MoulinBlanc);
                    break;
                case "M" :
                    AImagM.setImage(MoulinBlanc);
                    break;
                case "N" :
                    AImagN.setImage(MoulinBlanc);
                    break;
                case "O" :
                    AImagO.setImage(MoulinBlanc);
                    break;
                case "P" :
                    AImagP.setImage(MoulinBlanc);
                    break;
                case "Q" :
                    AImagQ.setImage(MoulinBlanc);
                    break;
                case "R" :
                    AImagR.setImage(MoulinBlanc);
                    break;
                case "S" :
                    AImagS.setImage(MoulinBlanc);
                    break;
                case "T" :
                    AImagT.setImage(MoulinBlanc);
                    break;
                case "U" :
                    AImagU.setImage(MoulinBlanc);
                    break;
                case "V" :
                    AImagV.setImage(MoulinBlanc);
                    break;
                case "W" :
                    AImagW.setImage(MoulinBlanc);
                    break;
                case "X" :
                    AImagX.setImage(MoulinBlanc);
                    break;

            }

        }

        for (int i = 0 ; i < j2.getListMoulinJouee().size() ; i++){
            switch (j2.getListMoulinJouee().get(i)){
                case "A" :
                    AImagA.setImage(MoulinNoir);
                    break;
                case "B" :
                    AImagB.setImage(MoulinNoir);
                    break;

                case "C" :
                    AImag2.setImage(MoulinNoir);
                    break;
                case "D" :
                    AImagD.setImage(MoulinNoir);
                    break;
                case "E" :
                    AImagE.setImage(MoulinNoir);
                    break;
                case "G" :
                    AImagG.setImage(MoulinNoir);
                    break;
                case "H" :
                    AImagH.setImage(MoulinNoir);
                    break;
                case "I" :
                    AImagI.setImage(MoulinNoir);
                    break;
                case "J" :
                    AImagJ.setImage(MoulinNoir);
                    break;
                case "K" :
                    AImagK.setImage(MoulinNoir);
                    break;
                case "L" :
                    AImagL.setImage(MoulinNoir);
                    break;
                case "M" :
                    AImagM.setImage(MoulinNoir);
                    break;
                case "N" :
                    AImagN.setImage(MoulinNoir);
                    break;
                case "O" :
                    AImagO.setImage(MoulinNoir);
                    break;
                case "P" :
                    AImagP.setImage(MoulinNoir);
                    break;
                case "Q" :
                    AImagQ.setImage(MoulinNoir);
                    break;
                case "R" :
                    AImagR.setImage(MoulinNoir);
                    break;
                case "S" :
                    AImagS.setImage(MoulinNoir);
                    break;
                case "T" :
                    AImagT.setImage(MoulinNoir);
                    break;
                case "U" :
                    AImagU.setImage(MoulinNoir);
                    break;
                case "V" :
                    AImagV.setImage(MoulinNoir);
                    break;
                case "W" :
                    AImagW.setImage(MoulinNoir);
                    break;
                case "X" :
                    AImagX.setImage(MoulinNoir);
                    break;
            }

        }
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
            play("A");
            reinitializerVue();
            this.setTextPions();
            this.gameRunning();
        }

    }

    @FXML
    public void moveB(){

        if (gameRunning){
            System.out.println("B ");
             play("B");
            reinitializerVue();
            setTextPions();
            this.gameRunning();
        }
    }

    @FXML
    public void moveC(){

        if (gameRunning){
            System.out.println("C");

            int i = play("C");

            reinitializerVue();
            setTextPions();
            this.gameRunning();
        }

    }

    @FXML
    public void moveD(){

        if (gameRunning){
            System.out.println("D");
            int i = play("D");

            reinitializerVue();
            setTextPions();
            this.gameRunning();
        }

    }

    @FXML
    public void moveE(){
        if (gameRunning){
            System.out.println("E");

            int i = play("E");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }

    @FXML
    public void moveF(){

        if (gameRunning){
            System.out.println("F");

            int i = play("F");
            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }

    @FXML
    public void moveG(){
        if (gameRunning){
            System.out.println("G");

            int i = play("G");
            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }

    @FXML
    public void moveH(){

        if (gameRunning){
            System.out.println("H");

            int i = play("H");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }

    @FXML
    public void moveI(){

        if (gameRunning){
            System.out.println("I");

            int i = play("I");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveJ(){
        if (gameRunning){
            System.out.println("J");

            int i = play("J");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}

    }
    @FXML
    public void moveK(){
        if (gameRunning){
            System.out.println("K");

            int i = play("K");
            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveL(){

        if (gameRunning){
            System.out.println("L");

            int i = play("L");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveM(){

        if (gameRunning){
            System.out.println("M");
            int i = play("M");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveN(){

        if (gameRunning){
            System.out.println("N");

            int i = play("N");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveO(){

        if (gameRunning){
            System.out.println("O");

            int i = play("O");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveP(){
        if (gameRunning){
            System.out.println("P");

            int i = play("P");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveQ(){

        if (gameRunning){
            System.out.println("Q");

            int i = play("Q");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveR(){
        if (gameRunning){
            System.out.println("R");

            int i = play("R");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveS(){

        if (gameRunning){
            System.out.println("S");

            int i = play("S");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveT(){

        if (gameRunning){
            System.out.println("T");

            int i = play("T");
            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveU(){

        if (gameRunning){
            System.out.println("U");

            int i = play("U");
            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveV(){

        if (gameRunning){
            System.out.println("V");

            int i = play("V");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveW(){

        if (gameRunning){
            System.out.println("W");

            int i = play("W");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }
    @FXML
    public void moveX(){

        if (gameRunning){
            System.out.println("X");

            int i = play("X");

            reinitializerVue();
            setTextPions();
            this.gameRunning();}
    }

}
