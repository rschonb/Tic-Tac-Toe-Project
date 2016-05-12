/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tic.tac.toe.javafx.TicTacToe;

/**
 *
 * @author GG_MacAir
 */
public class FXMLBoardGameController implements Initializable {
    private int turn = 0;
    
    
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    
    @FXML
    private Text X1;
    @FXML
    private Text X2;
    @FXML
    private Text X3;
    @FXML
    private Text X4;
    @FXML
    private Text X5;
    @FXML
    private Text X6;
    @FXML
    private Text X7;
    @FXML
    private Text X8;
    @FXML
    private Text X9;
    
    @FXML
    private Text O1;
    @FXML
    private Text O2;
    @FXML
    private Text O3;
    @FXML
    private Text O4;
    @FXML
    private Text O5;
    @FXML
    private Text O6;
    @FXML
    private Text O7;
    @FXML
    private Text O8;
    @FXML
    private Text O9;
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TicTacToe game = new TicTacToe();
        
        
        //Here we need to create the TicTacToe
    }    
    
    
    
    
    
    public void changeVisibilityX1(){
        boolean j = X1.isVisible();
        X1.setVisible(!j);
    }
    
    
    public void changeVisibilityX2(){
        boolean j = X2.isVisible();
        X2.setVisible(!j);
    }
    
    public void changeVisibilityX3(){
        boolean j = X3.isVisible();
        X3.setVisible(!j);
    }
    
    public void changeVisibilityX4(){
        boolean j = X4.isVisible();
        X4.setVisible(!j);
    }
    
    public void changeVisibilityX5(){
        boolean j = X5.isVisible();
        X5.setVisible(!j);
    }
    
    public void changeVisibilityX6(){
        boolean j = X6.isVisible();
        X6.setVisible(!j);
    }
    
    public void changeVisibilityX7(){
        boolean j = X7.isVisible();
        X7.setVisible(!j);
    }
    
    public void changeVisibilityX8(){
        boolean j = X8.isVisible();
        X8.setVisible(!j);
    }
    
    public void changeVisibilityX9(){
        boolean j = X9.isVisible();
        X9.setVisible(!j);
    }
    
    public void changeVisibilityO1(){
        boolean j = O1.isVisible();
        O1.setVisible(!j);
    }
    
    
    public void changeVisibilityO2(){
        boolean j = O2.isVisible();
        O2.setVisible(!j);
    }
    
    public void changeVisibilityO3(){
        boolean j = O3.isVisible();
        O3.setVisible(!j);
    }
    
    public void changeVisibilityO4(){
        boolean j = O4.isVisible();
        O4.setVisible(!j);
    }
    
    public void changeVisibilityO5(){
        boolean j = O5.isVisible();
        O5.setVisible(!j);
    }
    
    public void changeVisibilityO6(){
        boolean j = O6.isVisible();
        O6.setVisible(!j);
    }
    
    public void changeVisibilityO7(){
        boolean j = O7.isVisible();
        O7.setVisible(!j);
    }
    
    public void changeVisibilityO8(){
        boolean j = O8.isVisible();
        O8.setVisible(!j);
    }
    
    public void changeVisibilityO9(){
        boolean j = O9.isVisible();
        O9.setVisible(!j);
    }
}
