package game.windows;

import game.Board;
import game.Mouvement;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import game.Joueur;

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


    public Image MoulinNoir  = new Image("game/windows/Untitled2.png");
    public Image MoulinBlanc = new Image("game/windows/Untitled1.png");
    public Image MoulinTranparant = new Image("game/windows/Untitled.png");

    private Joueur j1 ;
    private Joueur j2;
    private Board game ;
    private int etatJeux ;
    private Mouvement mouvement;

    public Controller() {

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
                    game.removeMoulin(posStr);
                    j1.setNbPions(j1.getNbPions()+1);
                    idf = -1 ;
                }else {

                    if (game.caseVide(posStr)){
                        game.ajouterMoulin(posStr);
                        j1.setNbPions(j1.getNbPions()-1);
                        played = true;
                        idf =  j1.getIdentifiant();

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

                    game.removeMoulin(posStr);
                    j2.setNbPions(j2.getNbPions()+1);
                    idf = -1 ;

                }else {

                    if (game.caseVide(posStr)){
                        game.ajouterMoulin(posStr);
                        mouvement = new Mouvement(posStr , posStr);
                        j2.setNbPions(j2.getNbPions()-1);
                        played = true;
                        idf =  j2.getIdentifiant();
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

    @FXML
    public void moveA(){
        System.out.println("A ");

        int i = play("A");

        if ( i== 1)
            AImagA.setImage(MoulinBlanc);
        else if (i == 2)
            AImagA.setImage(MoulinNoir);
        else if (i == -1)
            AImagA.setImage(MoulinTranparant);
    }

    @FXML
    public void moveB(){
        System.out.println("B ");
        int i = play("B");
        if ( i== 1)
            AImagB.setImage(MoulinBlanc);
        else if (i == 2)
            AImagB.setImage(MoulinNoir);
        else if (i == -1)
            AImagB.setImage(MoulinTranparant);
    }

    @FXML
    public void moveC(){
        System.out.println("C");

        int i = play("C");

        if ( i== 1)
            AImag2.setImage(MoulinBlanc);
        else if (i == 2)
            AImag2.setImage(MoulinNoir);
        else if (i == -1)
            AImag2.setImage(MoulinTranparant);

    }

    @FXML
    public void moveD(){
        System.out.println("D");

        int i = play("D");

        if ( i== 1)
            AImagD.setImage(MoulinBlanc);
        else if (i == 2)
            AImagD.setImage(MoulinNoir);
        else if (i == -1)
            AImagD.setImage(MoulinTranparant);


    }

    @FXML
    public void moveE(){
        System.out.println("E");

        int i = play("E");

        if ( i== 1)
            AImagE.setImage(MoulinBlanc);
        else if (i == 2)
            AImagE.setImage(MoulinNoir);
        else if (i == -1)
            AImagE.setImage(MoulinTranparant);

    }

    @FXML
    public void moveF(){
        System.out.println("F");

        int i = play("F");

        if ( i== 1)
            AImagF.setImage(MoulinBlanc);
        else if (i == 2)
            AImagF.setImage(MoulinNoir);
        else if (i == -1)
            AImagF.setImage(MoulinTranparant);

    }

    @FXML
    public void moveG(){

        System.out.println("G");

        int i = play("G");

        if ( i== 1)
            AImagG.setImage(MoulinBlanc);
        else if (i == 2)
            AImagG.setImage(MoulinNoir);
        else if (i == -1)
            AImagG.setImage(MoulinTranparant);
    }

    @FXML
    public void moveH(){
        System.out.println("H");

        int i = play("H");

        if ( i== 1)
            AImagH.setImage(MoulinBlanc);
        else if (i == 2)
            AImagH.setImage(MoulinNoir);
        else if (i == -1)
            AImagH.setImage(MoulinTranparant);
    }

    @FXML
    public void moveI(){
        System.out.println("I");

        int i = play("I");

        if ( i== 1)
            AImagI.setImage(MoulinBlanc);
        else if (i == 2)
            AImagI.setImage(MoulinNoir);
        else if (i == -1)
            AImagI.setImage(MoulinTranparant);
    }
    @FXML
    public void moveJ(){
        System.out.println("J");

        int i = play("J");

        if ( i== 1)
            AImagJ.setImage(MoulinBlanc);
        else if (i == 2)
            AImagJ.setImage(MoulinNoir);
        else if (i == -1)
            AImagJ.setImage(MoulinTranparant);

    }
    @FXML
    public void moveK(){
        System.out.println("K");

        int i = play("K");

        if ( i== 1)
            AImagK.setImage(MoulinBlanc);
        else if (i == 2)
            AImagK.setImage(MoulinNoir);
        else if (i == -1)
            AImagK.setImage(MoulinTranparant);
    }
    @FXML
    public void moveL(){
        System.out.println("L");

        int i = play("L");

        if ( i== 1)
            AImagL.setImage(MoulinBlanc);
        else if (i == 2)
            AImagL.setImage(MoulinNoir);
        else if (i == -1)
            AImagL.setImage(MoulinTranparant);
    }
    @FXML
    public void moveM(){
        System.out.println("M");

        int i = play("M");

        if ( i== 1)
            AImagM.setImage(MoulinBlanc);
        else if (i == 2)
            AImagM.setImage(MoulinNoir);
        else if (i == -1)
            AImagM.setImage(MoulinTranparant);
    }
    @FXML
    public void moveN(){
        System.out.println("N");

        int i = play("N");

        if ( i== 1)
            AImagN.setImage(MoulinBlanc);
        else if (i == 2)
            AImagN.setImage(MoulinNoir);
        else if (i == -1)
            AImagN.setImage(MoulinTranparant);
    }
    @FXML
    public void moveO(){
        System.out.println("O");

        int i = play("O");

        if ( i== 1)
            AImagO.setImage(MoulinBlanc);
        else if (i == 2)
            AImagO.setImage(MoulinNoir);
        else if (i == -1)
            AImagO.setImage(MoulinTranparant);
    }
    @FXML
    public void moveP(){
        System.out.println("P");

        int i = play("P");

        if ( i== 1)
            AImagP.setImage(MoulinBlanc);
        else if (i == 2)
            AImagP.setImage(MoulinNoir);
        else if (i == -1)
            AImagP.setImage(MoulinTranparant);
    }
    @FXML
    public void moveQ(){
        System.out.println("Q");

        int i = play("Q");

        if ( i== 1)
            AImagQ.setImage(MoulinBlanc);
        else if (i == 2)
            AImagQ.setImage(MoulinNoir);
        else if (i == -1)
            AImagQ.setImage(MoulinTranparant);
    }
    @FXML
    public void moveR(){
        System.out.println("R");

        int i = play("R");

        if ( i== 1)
            AImagR.setImage(MoulinBlanc);
        else if (i == 2)
            AImagR.setImage(MoulinNoir);
        else if (i == -1)
            AImagR.setImage(MoulinTranparant);
    }
    @FXML
    public void moveS(){
        System.out.println("S");

        int i = play("S");

        if ( i== 1)
            AImagS.setImage(MoulinBlanc);
        else if (i == 2)
            AImagS.setImage(MoulinNoir);
        else if (i == -1)
            AImagS.setImage(MoulinTranparant);
    }
    @FXML
    public void moveT(){
        System.out.println("T");

        int i = play("T");

        if ( i== 1)
            AImagT.setImage(MoulinBlanc);
        else if (i == 2)
            AImagT.setImage(MoulinNoir);
        else if (i == -1)
            AImagT.setImage(MoulinTranparant);
    }
    @FXML
    public void moveU(){
        System.out.println("U");

        int i = play("U");

        if ( i== 1)
            AImagU.setImage(MoulinBlanc);
        else if (i == 2)
            AImagU.setImage(MoulinNoir);
        else if (i == -1)
            AImagU.setImage(MoulinTranparant);
    }
    @FXML
    public void moveV(){
        System.out.println("V");

        int i = play("V");

        if ( i== 1)
            AImagV.setImage(MoulinBlanc);
        else if (i == 2)
            AImagV.setImage(MoulinNoir);
        else if (i == -1)
            AImagV.setImage(MoulinTranparant);
    }
    @FXML
    public void moveW(){
        System.out.println("W");

        int i = play("W");

        if ( i== 1)
            AImagW.setImage(MoulinBlanc);
        else if (i == 2)
            AImagW.setImage(MoulinNoir);
        else if (i == -1)
            AImagW.setImage(MoulinTranparant);
    }
    @FXML
    public void moveX(){
        System.out.println("X");

        int i = play("X");

        if ( i== 1)
            AImagX.setImage(MoulinBlanc);
        else if (i == 2)
            AImagX.setImage(MoulinNoir);
        else if (i == -1)
            AImagX.setImage(MoulinTranparant);
    }

}
