package windows;

import javax.swing.*;
import java.awt.*;


public class TableDeJeu extends JFrame {

    private ImageIcon imageDeTableDeJeu ;
    private JLabel label1 ;

    public TableDeJeu() throws HeadlessException {
        //adding image
        imageDeTableDeJeu = new ImageIcon(getClass().getResource("TableDeJeu2.png"));
        label1 = new JLabel(imageDeTableDeJeu);

        //adding to the jframe
        this.add(label1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700 ,600);
        this.setVisible(true);
        this.pack();
        this.setTitle("Jeu de Moulin");
    }
}
