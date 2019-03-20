package game.windows.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    @FXML
    public Button b1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void marhce2(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/game/windows/MachineVsHumain/GameWindow2.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage =new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    @FXML
    public void marche( ){
        System.out.println(" tert ");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/game/windows/GameWindow.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage =new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }
}
