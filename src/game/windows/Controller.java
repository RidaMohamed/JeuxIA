package game.windows;

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
    private Joueur j1 ;
    private Joueur j2;

    public Controller() {

         j1 = new Joueur("A1" , 1 , 9 ,1);
         j2 = new Joueur("A12" , 2 , 9 , 0);
         game.Board game = new game.Board(j1 , j2);
         int i = game.isGameOver() ;
    }

    @FXML
    public void move(){

        System.out.println("im here ");
    }
}
