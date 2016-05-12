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
    private int turn = 1;
    
    
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
    
    
    
 
@FXML
    public void ChangeVis1(ActionEvent event){
        if(X1.isVisible() == true || O1.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX1();
            changeVisibilityb1();
        }else if(turn == 2){
            changeVisibilityO1();
            changeVisibilityb1();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis2(ActionEvent event){
        if(X2.isVisible() == true || O2.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX2();
            changeVisibilityb2();
        }else if(turn == 2){
            changeVisibilityO2();
            changeVisibilityb2();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis3(ActionEvent event){
        if(X3.isVisible() == true || O3.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX3();
            changeVisibilityb3();
        }else if(turn == 2){
            changeVisibilityO3();
            changeVisibilityb3();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis4(ActionEvent event){
        if(X4.isVisible() == true || O4.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX4();
            changeVisibilityb4();
        }else if(turn == 2){
            changeVisibilityO4();
            changeVisibilityb4();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis5(ActionEvent event){
        if(X5.isVisible() == true || O5.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX5();
            changeVisibilityb5();
        }else if(turn == 2){
            changeVisibilityO5();
            changeVisibilityb5();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis6(ActionEvent event){
        if(X6.isVisible() == true || O6.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX6();
            changeVisibilityb6();
        }else if(turn == 2){
            changeVisibilityO6();
            changeVisibilityb6();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis7(ActionEvent event){
        if(X7.isVisible() == true || O7.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX7();
            changeVisibilityb7();
        }else if(turn == 2){
            changeVisibilityO7();
            changeVisibilityb7();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis8(ActionEvent event){
        if(X8.isVisible() == true || O8.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX8();
            changeVisibilityb8();
        }else if(turn == 2){
            changeVisibilityO8();
            changeVisibilityb8();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
@FXML
    public void ChangeVis9(ActionEvent event){
        if(X9.isVisible() == true || O9.isVisible() == true){
            return;
        }else if(turn == 1){
            changeVisibilityX9();
            changeVisibilityb9();
        }else if(turn == 2){
            changeVisibilityO9();
            changeVisibilityb9();
        }else{
            return;
        }
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TicTacToe game = new TicTacToe();
        setAllXAndOOff();
        
        
        //Here we need to create the TicTacToe
    }    
    
    public void setAllXAndOOff(){
        O1.setVisible(false);
        O2.setVisible(false);
        O3.setVisible(false);
        O4.setVisible(false);
        O5.setVisible(false);
        O6.setVisible(false);
        O7.setVisible(false);
        O8.setVisible(false);
        O9.setVisible(false);
        X1.setVisible(false);
        X2.setVisible(false);
        X3.setVisible(false);
        X4.setVisible(false);
        X5.setVisible(false);
        X6.setVisible(false);
        X7.setVisible(false);
        X8.setVisible(false);
        X9.setVisible(false);
        
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
    public void changeVisibilityb1(){
        boolean j = b1.isVisible();
        b1.setVisible(!j);
    }
    
    
    public void changeVisibilityb2(){
        boolean j = b2.isVisible();
        b2.setVisible(!j);
    }
    
    public void changeVisibilityb3(){
        boolean j = b3.isVisible();
        b3.setVisible(!j);
    }
    
    public void changeVisibilityb4(){
        boolean j = b4.isVisible();
        b4.setVisible(!j);
    }
    
    public void changeVisibilityb5(){
        boolean j = b5.isVisible();
        b5.setVisible(!j);
    }
    
    public void changeVisibilityb6(){
        boolean j = b6.isVisible();
        b6.setVisible(!j);
    }
    
    public void changeVisibilityb7(){
        boolean j = b7.isVisible();
        b7.setVisible(!j);
    }
    
    public void changeVisibilityb8(){
        boolean j = b8.isVisible();
        b8.setVisible(!j);
    }
    
    public void changeVisibilityb9(){
        boolean j = b9.isVisible();
        b9.setVisible(!j);
    }
}
