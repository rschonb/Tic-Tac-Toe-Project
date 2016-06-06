/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tic.tac.toe.javafx.Settings;
import static tic.tac.toe.javafx.Settings.instance;
import tic.tac.toe.javafx.TicTacToeJavaFX;

/**
 *
 * @author GG_MacAir
 */
public class FXMLBoardGameController implements Initializable {
    private boolean isPicked = false;
    private int win;
    private int checkedPlayers = 2;
    
    private int numSelected = 0;
    
    private boolean compGame = false;
    
    
    
    private int gameNum = 1;
    private int players;
    private boolean startYes;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int seven;
    private int eight;
    private int nine;
    private boolean over;
    private int winner;
    private int turn;
    private int turnNumber;
    private int square;
    private boolean check;
    private int tempA;
    private ArrayList<int[]> probDist = new ArrayList<int[]>();
    private boolean found;
    private int[] probArr;
    private int id;
    private int[] addArr = new int[10];
    private int[][] results = new int[9][2];
    private int choice;
    private double[] dist = new double[9];
    private boolean done;
    int winPoint;
    int firstPlayer;
    
    int numPlayFromLastGame;
    
    @FXML
    private Button replayButton;

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
    private Button startButton;
    
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check1;
    
    @FXML
    private Button DataButton;
    
    @FXML
    private MenuItem Easy;
    
    @FXML
    private MenuItem Medium;
    
    @FXML
    private MenuItem Hard;
    
    @FXML
    private MenuButton ChooseDiff;
    
    
    @FXML
    public void setEasy(ActionEvent event){
        try{
            loadDataA();
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch(IOException e){
            System.out.println("file not found");
        }catch(ClassNotFoundException e){
            System.out.println("file not found");
        }
    }
    
    @FXML
    public void setMedium(ActionEvent event){
        try{
            loadDataB();
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch(IOException e){
            System.out.println("file not found");
        }catch(ClassNotFoundException e){
            System.out.println("file not found");
        }
    }
    
    @FXML
    public void setHard(ActionEvent event){
        try{
            loadData();
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch(IOException e){
            System.out.println("file not found");
        }catch(ClassNotFoundException e){
            System.out.println("file not found");
        }
    }
    
    
    
    
    
    
    @FXML
    public void startButton(ActionEvent event){
        numPlayFromLastGame = checkedPlayers;
        ConstructorTicTacToe();
        showButtons();
        if(checkedPlayers == 2){
            startTwoPlayers();
        }else if(checkedPlayers == 1){
            startOnePlayers();
        } else {
            return;
        }
        
        
        
    }
    
    
    @FXML
    public void replayButtonAction(ActionEvent event){
        numPlayFromLastGame = checkedPlayers;
        gameNum = gameNum+1;
        ConstructorTicTacToe();
        showButtons();
        if(numPlayFromLastGame == 2){
            startTwoPlayers();
        }else if(numPlayFromLastGame == 1){
            startOnePlayers();
        } else {
            return;
        }
        
        
        
    }
    
    @FXML
    public void TwoPlayers(ActionEvent event){
        checkedPlayers = 2;
        
        
    }
    
    @FXML
    public void OnePlayers(ActionEvent event){
        checkedPlayers = 1;
        
    }
 
@FXML
    public void ChangeVis1(ActionEvent event){
        

        if(X1.isVisible() == true || O1.isVisible() == true){
            return;
        }else if(turn == 1){
            square = 1;
            isPicked = true;
            one = 1;
        }else if(turn == 2){
            isPicked = true;
            one = 2;
            square = 1;
        }
        
        turnNumber++;
        
        hasBeenPicked();
        
        
    }
@FXML
    public void ChangeVis2(ActionEvent event){
        
        
        if(X2.isVisible() == true || O2.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            square = 2;
            two = 1;
        }else if(turn == 2){
            isPicked = true;
            two = 2;
            square = 2;
        }
        turnNumber++;
        
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis3(ActionEvent event){
       
        
        
        if(X3.isVisible() == true || O3.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            three = 1;
            square = 3;
        }else if(turn == 2){
            isPicked = true;
            three = 2;
            square = 3;
        }
        turnNumber++;
        
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis4(ActionEvent event){
       
        
        if(X4.isVisible() == true || O4.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            four = 1;
            square = 4;
        }else if(turn == 2){
            isPicked = true;
            four = 2;
            square = 4;
        }
        turnNumber++;
       
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis5(ActionEvent event){
        
        
        if(X5.isVisible() == true || O5.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            five = 1;
            square = 5;
        }else if(turn == 2){
            isPicked = true;
            five = 2;
            square = 5;
        }
        turnNumber++;
      
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis6(ActionEvent event){
       
        if(X6.isVisible() == true || O6.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            six = 1;
            square = 6;
        }else if(turn == 2){
            isPicked = true;
            six = 2;
            square = 6;
        }
        turnNumber++;
       
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis7(ActionEvent event){
        
        
        if(X7.isVisible() == true || O7.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            seven = 1;
            square = 7;
        }else if(turn == 2){
            isPicked = true;
            seven = 2;
            square = 7;
        }
        turnNumber++;
    
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis8(ActionEvent event){
       
        if(X8.isVisible() == true || O8.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            eight = 1;
            square = 8;
        }else if(turn == 2){
            isPicked = true;
            eight = 2;
            square = 8;
        }
        turnNumber++;
   
        hasBeenPicked();
        
    }
@FXML
    public void ChangeVis9(ActionEvent event){
        
        if(X9.isVisible() == true || O9.isVisible() == true){
            return;
        }else if(turn == 1){
            isPicked = true;
            nine = 1;
            square = 9;
        }else if(turn == 2){
            isPicked = true;
            nine = 2;
            square = 9;
        }
        turnNumber++;
        
        hasBeenPicked();
        
    }
    
    @FXML
    public void handleShowData(ActionEvent event) {
        try {
            TicTacToeJavaFX.getAppInstance().showGraphView();
        } catch (IOException ex) {
            //Logger.getLogger(FXMLBoardGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void hideButtons(){
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
        
        
        
    }
    
    public void showButtons(){
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        b6.setVisible(true);
        b7.setVisible(true);
        b8.setVisible(true);
        b9.setVisible(true);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ConstructorTicTacToe(); 
        setAllXAndOOff();
        hideButtons();
        try{
            loadData();
        } catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch(IOException e){
            System.out.println("file not found");
        }catch(ClassNotFoundException e){
            System.out.println("file not found");
        }
           
        
    }    
    
    
    public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("t.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<int[]> temp = (List<int[]>) ois.readObject();
        probDist = (ArrayList<int[]>) temp;
        ois.close();    
        
        
        
    }
    
    public void loadDataA() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("a.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<int[]> temp = (List<int[]>) ois.readObject();
        probDist = (ArrayList<int[]>) temp;
        ois.close();    
        
        
        
    }
    
    public void loadDataB() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("b.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<int[]> temp = (List<int[]>) ois.readObject();
        probDist = (ArrayList<int[]>) temp;
        ois.close();    
        
        
        
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
    
    public void pickSquareWin(){
        found = false;
        for(int i = 0; i < probDist.size(); i++){
            int[] tempArray = probDist.get(i);
            int tempCheckerTwo = tempArray[0];
            int tempCheckerOne = ((100000000 * one) + (10000000 * two) + (1000000 * three) + (100000 * four) + (10000 * five) + (1000 * six) + (100 * seven) + (10 * eight) + (1 * nine));
            id = tempCheckerOne;
            if(tempCheckerOne == tempCheckerTwo){
                found = true;
                probArr = tempArray;
                runPickerWin();
                break;
            }
        }
        if(found == false){
            addArr[0] = id;
            addArr[1] = 1;
            addArr[2] = 1;
            addArr[3] = 1;
            addArr[4] = 1;
            addArr[5] = 1;
            addArr[6] = 1;
            addArr[7] = 1;
            addArr[8] = 1;
            addArr[9] = 1;
            int currId = id;
            int[] addThis = new int[10];
            for(int i = 0; i < 10; i++){
                addThis[i] = addArr[i];
            }
            probDist.add(addThis);
            probArr = addArr;
            runPicker();
        }
    }
    
    public void runPickerWin(){
        check = false;
        while(check == false){
            square = 1;
            for(int i = 2; i < 10; i++){
                if(probArr[i] > probArr[square]){
                    square = i;
                }
            }
            check = true;
            checkPicked();
            if(check == false){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = ((100000000 * one) + (10000000 * two) + (1000000 * three) + (100000 * four) + (10000 * five) + (1000 * six) + (100 * seven) + (10 * eight) + (1 * nine));
                    if(tempCheckerOne == tempCheckerTwo){
                        int[] temp = probDist.get(i);
                        if(square == 1){
                            temp[1] = 0;
                        } else if(square == 2){
                            temp[2] = 0;
                        } else if(square == 3){
                            temp[3] = 0;
                        } else if(square == 4){
                            temp[4] = 0;
                        } else if(square == 5){
                            temp[5] = 0;
                        } else if(square == 6){
                            temp[6] = 0;
                        } else if(square == 7){
                            temp[7] = 0;
                        } else if(square == 8){
                            temp[8] = 0;
                        } else {
                            temp[9] = 0;
                        }
                        probDist.set(i, temp);
                    }
                }
            }
        }
        results[(turnNumber - 1)][0] = id;
        results[(turnNumber - 1)][1] = square;
    }
    
    
    
    public void TwoPlayersTurn(){
        pickSquareWin();
        attributeSquare();
        checkOver2();
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
    }
    
    
    
    public void ConstructorTicTacToe(){
        startYes = false;
        compGame = false;
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
        seven = 0;
        eight = 0;
        nine = 0;
        winner = 0;
        turn = 0;
        players = -1;
        turnNumber = 0;
    }
    
    public void hasBeenPicked(){
       
        attributeSquare();
        checkOver2();
        if(turn == 1){turn = 2;}
        else if(turn == 2){turn = 1;}
        
        if(compGame == true && turnNumber != 9){
            
            turnNumber++;
            TwoPlayersTurn();

           
        }
        
        
    }
    
    public void startTwoPlayers(){
        setAllXAndOOff();
        showButtons();
        
        ConstructorTicTacToe();
        isPicked = false;
        numSelected = 0;
        turn = 1;
        turnNumber = 0;
        over = false;
        
        
        
        
    }
    
    public void startOnePlayers(){
        setAllXAndOOff();
        hideButtons();
        showButtons();
        ConstructorTicTacToe();
        isPicked = false;
        numSelected = 0;
        turn = 1;
        turnNumber = 0;
        over = false;
        compGame = true;
        
        
    }
    
    public void start(int tempPlayers){
        probDist = Settings.getList();
        tempA = players;
        reset();
        players = tempA;
        setAllXAndOOff();
        //THIS CLEARS THE BOARD
        players = tempPlayers;
        if(players == 10000){
            for(int i = 0; i < 10000; i++){
                this.runGame();
            }
            saveData();
        }
        if(players < 0 || players > 2){
            setAllXAndOOff();
            //THIS CLEARS THE BOARD
            
            
            
            //THIS TELLS YOU WHAT TO INPUT
        } else{       
            this.runGame();
        }
    }
    
    public void saveData(){
        Settings.setList(probDist);
        
        
        
    }
    
    
    public void runGame(){
        turn = 1;
        turnNumber = 0;
        over = false;
        setAllXAndOOff();
        //THIS CLEARS THE BOARD
        checkOver();
        checkWinner();
    }
    
    public void runTurn(){
        turnNumber++;
        if(players == 0){
            pickSquareComp();
        } else if(players == 1){
            if(turn == 1){
                pickSquareUser();
            } else {
                pickSquareComp();
            }
        } else {
            pickSquareUser();
        }
        setAllXAndOOff();
        //THIS CLEARS THE BOARD
        //attributeSquare();
        //printBoard();
    }
    
    public void pickSquareUser(){
        check = false;
        while(check == false){
            //ALL OF THIS WILL NEED TO BE CHANGED FOR USER INPUT
            
            //Thread.sleep(250);
           
            if((square < 0) || (square > 9)){
                check = false;
            } else if(square == 0){
                reset();
                System.exit(1);
            } else {
                check = true;
            }
            //checkPicked();
        }
    }
    
    public void pickSquareComp(){
        found = false;
        for(int i = 0; i < probDist.size(); i++){
            int[] tempArray = probDist.get(i);
            int tempCheckerTwo = tempArray[0];
            int tempCheckerOne = ((100000000 * one) + (10000000 * two) + (1000000 * three) + (100000 * four) + (10000 * five) + (1000 * six) + (100 * seven) + (10 * eight) + (1 * nine));
            id = tempCheckerOne;
            if(tempCheckerOne == tempCheckerTwo){
                found = true;
                probArr = tempArray;
                runPicker();
                break;
            }
        }
        if(found == false){
            addArr[0] = id;
            addArr[1] = 1;
            addArr[2] = 1;
            addArr[3] = 1;
            addArr[4] = 1;
            addArr[5] = 1;
            addArr[6] = 1;
            addArr[7] = 1;
            addArr[8] = 1;
            addArr[9] = 1;
            int currId = id;
            int[] addThis = new int[10];
            for(int i = 0; i < 10; i++){
                addThis[i] = addArr[i];
            }
            probDist.add(addThis);
            probArr = addArr;
            runPicker();
        }
    }
    
    public void runPicker(){
        check = false;
        while(check == false){
            double x = Math.random();
            int sum = (probArr[1] + probArr[2] + probArr[3] + probArr[4] + probArr[5] + probArr[6] + probArr[7] + probArr[8] + probArr[9]);
            dist[0] = ((double)(probArr[1]) / (double)(sum));
            dist[1] = (((double)(probArr[2]) / (double)(sum)) + dist[0]);
            dist[2] = (((double)(probArr[3]) / (double)(sum)) + dist[1]);
            dist[3] = (((double)(probArr[4]) / (double)(sum)) + dist[2]);
            dist[4] = (((double)(probArr[5]) / (double)(sum)) + dist[3]);
            dist[5] = (((double)(probArr[6]) / (double)(sum)) + dist[4]);
            dist[6] = (((double)(probArr[7]) / (double)(sum)) + dist[5]);
            dist[7] = (((double)(probArr[8]) / (double)(sum)) + dist[6]);
            dist[8] = (((double)(probArr[9]) / (double)(sum)) + dist[7]);
            if(x < dist[0]){
                square = 1;
            } else if(x < dist[1]){
                square = 2;
            } else if(x < dist[2]){
                square = 3;
            } else if(x < dist[3]){
                square = 4;
            } else if(x < dist[4]){
                square = 5;
            } else if(x < dist[5]){
                square = 6;
            } else if(x < dist[6]){
                square = 7;
            } else if(x < dist[7]){
                square = 8;
            } else {
                square = 9;
            }
            check = true;
            //checkPicked();
            if(check == false){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = ((100000000 * one) + (10000000 * two) + (1000000 * three) + (100000 * four) + (10000 * five) + (1000 * six) + (100 * seven) + (10 * eight) + (1 * nine));
                    if(tempCheckerOne == tempCheckerTwo){
                        int[] temp = probDist.get(i);
                        if(square == 1){
                            temp[1] = 0;
                        } else if(square == 2){
                            temp[2] = 0;
                        } else if(square == 3){
                            temp[3] = 0;
                        } else if(square == 4){
                            temp[4] = 0;
                        } else if(square == 5){
                            temp[5] = 0;
                        } else if(square == 6){
                            temp[6] = 0;
                        } else if(square == 7){
                            temp[7] = 0;
                        } else if(square == 8){
                            temp[8] = 0;
                        } else {
                            temp[9] = 0;
                        }
                        probDist.set(i, temp);
                    }
                }
            }
        }
        results[(turnNumber - 1)][0] = id;
        results[(turnNumber - 1)][1] = square;
    }
    
    public void checkPicked(){
        if(square == 1 && one != 0){
            check = false;
        }
        if(square == 2 && two != 0){
            check = false;
        }
        if(square == 3 && three != 0){
            check = false;
        }
        if(square == 4 && four != 0){
            check = false;
        }
        if(square == 5 && five != 0){
            check = false;
        }
        if(square == 6 && six != 0){
            check = false;
        }
        if(square == 7 && seven != 0){
            check = false;
        }
        if(square == 8 && eight != 0){
            check = false;
        }
        if(square == 9 && nine != 0){
            check = false;
        }
    }
    
    public void attributeSquare(){
        
        if(turn == 1){
            if(square == 1 && X1.isVisible() == false){
                one = 1;
                changeVisibilityX1();
                changeVisibilityb1();
            } else if(square == 2 && X2.isVisible() == false){
                two = 1;
                changeVisibilityX2();
                changeVisibilityb2();
            } else if(square == 3 && X3.isVisible() == false){
                three = 1;
                changeVisibilityX3();
                changeVisibilityb3();
            } else if(square == 4 && X4.isVisible() == false){
                four = 1;
                changeVisibilityX4();
                changeVisibilityb4();
            } else if(square == 5 && X5.isVisible() == false){
                five = 1;
                changeVisibilityX5();
                changeVisibilityb5();
            } else if(square == 6 && X6.isVisible() == false){
                six = 1;
                changeVisibilityX6();
                changeVisibilityb6();
            } else if(square == 7 && X7.isVisible() == false){
                seven = 1;
                changeVisibilityX7();
                changeVisibilityb7();
            } else if(square == 8 && X8.isVisible() == false){
                eight = 1;
                changeVisibilityX8();
                changeVisibilityb8();
            } else if(X9.isVisible() == false){
                nine = 1;
                changeVisibilityX9();
                changeVisibilityb9();
            }
        }
        if(turn == 2){
            if(square == 1 && O1.isVisible() == false){
                one = 2;
                changeVisibilityO1();
                changeVisibilityb1();
            } else if(square == 2 && O2.isVisible() == false){
                two = 2;
                changeVisibilityO2();
                changeVisibilityb2();
            } else if(square == 3 && O3.isVisible() == false){
                three = 2;
                changeVisibilityO3();
                changeVisibilityb3();
            } else if(square == 4 && O4.isVisible() == false){
                four = 2;
                changeVisibilityO4();
                changeVisibilityb4();
            } else if(square == 5 && O5.isVisible() == false){
                five = 2;
                changeVisibilityO5();
                changeVisibilityb5();
            } else if(square == 6 && O6.isVisible() == false){
                six = 2;
                changeVisibilityO6();
                changeVisibilityb6();
            } else if(square == 7 && O7.isVisible() == false){
                seven = 2;
                changeVisibilityO7();
                changeVisibilityb7();
            } else if(square == 8 && O8.isVisible() == false){
                eight = 2;
                changeVisibilityO8();
                changeVisibilityb8();
            } else if(O9.isVisible() == false){
                nine = 2;
                changeVisibilityO9();
                changeVisibilityb9();
            }
        }
        /*
        if(turn == 1){
            turn = 2;
        } else {
            turn = 1;
        }
        */
    }
    
    
    public void printBoard(){
        //ALL OF THIS NEEDS TO BE CHANGED VIA FXML
        
        System.out.print("       |       |       " + "\n");
        if(one == 1){
            System.out.print("   X   ");
        } else if(one == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        if(two == 1){
            System.out.print("|   X   |");
        } else if(two == 2){
            System.out.print("|   O   |");
        } else {
            System.out.print("|       |");
        }
        if(three == 1){
            System.out.print("   X   ");
        } else if(three == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        System.out.print("\n");
        System.out.print("       |       |       " + "\n");
        System.out.print("________________________" + "\n");
        System.out.print("       |       |       " + "\n");
        if(four == 1){
            System.out.print("   X   ");
        } else if(four == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        if(five == 1){
            System.out.print("|   X   |");
        } else if(five == 2){
            System.out.print("|   O   |");
        } else {
            System.out.print("|       |");
        }
        if(six == 1){
            System.out.print("   X   ");
        } else if(six == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        System.out.print("\n");
        System.out.print("       |       |       " + "\n");
        System.out.print("________________________" + "\n");
        System.out.print("       |       |       " + "\n");
        if(seven == 1){
            System.out.print("   X   ");
        } else if(seven == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        if(eight == 1){
            System.out.print("|   X   |");
        } else if(eight == 2){
            System.out.print("|   O   |");
        } else {
            System.out.print("|       |");
        }
        if(nine == 1){
            System.out.print("   X   ");
        } else if(nine == 2){
            System.out.print("   O   ");
        } else {
            System.out.print("       ");
        }
        System.out.print("\n");
        System.out.print("       |       |       " + "\n");
    }
    
   
    public void checkOver(){
        over = false;
        while(over == false){
            if((one == 1) && (two == 1) && (three == 1)){
                over = true;
                winner = 1;
            }
            if((four == 1) && (five == 1) && (six == 1)){
                over = true;
                winner = 1;
            }
            if((seven == 1) && (eight == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((one == 1) && (four == 1) && (seven == 1)){
                over = true;
                winner = 1;
            }
            if((two == 1) && (five == 1) && (eight == 1)){
                over = true;
                winner = 1;
            }
            if((three == 1) && (six == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((one == 1) && (five == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((seven == 1) && (five == 1) && (three == 1)){
                over = true;
                winner = 1;
            }
            if((one == 2) && (two == 2) && (three == 2)){
                over = true;
                winner = 2;
            }
            if((four == 2) && (five == 2) && (six == 2)){
                over = true;
                winner = 2;
            }
            if((seven == 2) && (eight == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((one == 2) && (four == 2) && (seven == 2)){
                over = true;
                winner = 2;
            }
            if((two == 2) && (five == 2) && (eight == 2)){
                over = true;
                winner = 2;
            }
            if((three == 2) && (six == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((one == 2) && (five == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((seven == 2) && (five == 2) && (three == 2)){
                over = true;
                winner = 2;
            }
            if((turnNumber == 9)  && (winner == 0)){
                over = true;
                winner = 0;
            }
            if(over == false){
                this.runTurn();
            }
        }
    }
    public void checkOver2(){
        over = false;
        if(over == false){
            if((one == 1) && (two == 1) && (three == 1)){
                over = true;
                winner = 1;
            }
            if((four == 1) && (five == 1) && (six == 1)){
                over = true;
                winner = 1;
            }
            if((seven == 1) && (eight == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((one == 1) && (four == 1) && (seven == 1)){
                over = true;
                winner = 1;
            }
            if((two == 1) && (five == 1) && (eight == 1)){
                over = true;
                winner = 1;
            }
            if((three == 1) && (six == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((one == 1) && (five == 1) && (nine == 1)){
                over = true;
                winner = 1;
            }
            if((seven == 1) && (five == 1) && (three == 1)){
                over = true;
                winner = 1;
            }
            if((one == 2) && (two == 2) && (three == 2)){
                over = true;
                winner = 2;
            }
            if((four == 2) && (five == 2) && (six == 2)){
                over = true;
                winner = 2;
            }
            if((seven == 2) && (eight == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((one == 2) && (four == 2) && (seven == 2)){
                over = true;
                winner = 2;
            }
            if((two == 2) && (five == 2) && (eight == 2)){
                over = true;
                winner = 2;
            }
            if((three == 2) && (six == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((one == 2) && (five == 2) && (nine == 2)){
                over = true;
                winner = 2;
            }
            if((seven == 2) && (five == 2) && (three == 2)){
                over = true;
                winner = 2;
            }
            if((turnNumber == 9)  && (winner == 0)){
                over = true;
                winner = 0;
            }
            if(over == true){
                
                displayWinner();
            }
        }
    }
    
    
    
    public void checkWinner(){
        if(winner == 0){
            if(players == 0){
                runCompensation();
            }
            Scanner scanner = new Scanner(System.in);
            //System.out.println("It's a tie! Press enter to play again.");
            win = 0;
            String input = scanner.nextLine();
            if(input.equals("")){
                tempA = players;
                reset();
                start(tempA);
            } else {
                System.exit(1);
            }
        } else if(winner == 1){
            if(players == 0){
                runCompensation();
            }
            Scanner scanner = new Scanner(System.in);
            //System.out.println("X wins! Press enter to play again.");
            win = 1;
            String input = scanner.nextLine();
            if(input.equals("")){
                tempA = players;
                reset();
                start(tempA);
            } else {
                System.exit(1);
            }
        } else {
            if(players == 0){
                runCompensation();
            }
            Scanner scanner = new Scanner(System.in);
            //System.out.println("O wins! Press enter to play again.");
            win = 2;
            String input = scanner.nextLine();
            if(input.equals("")){
                tempA = players;
                reset();
                start(tempA);
            } else {
                System.exit(1);
            }
        }
    }
    
    
    public void displayWinner(){
        ArrayList<Boolean> wins = Settings.getWins();
        
        
        setAllXAndOOff();
        hideButtons();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Results");
        alert.setHeaderText("Results Message");
        
            if(winner == 0){ //this means x has tied with o
                alert.setContentText("X and O have tied");
                //alert.showAndWait();
            } else if (winner == 1){ //this means x has won
                alert.setContentText("X has won");
                wins.add(true);
                //alert.showAndWait();
            } else if(winner == 2){ //this means x has lost
                alert.setContentText("O has won");
                wins.add(false);
            
        }
        Settings.setWins(wins);
        Settings.save();
        alert.showAndWait();
    }
    
    public void runCompensation(){
        if(winner == 0){
            for(int n = 0; n < 9; n++){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = results[n][0];
                    if(tempCheckerOne == tempCheckerTwo){
                        int h = results[n][1];
                        tempArray[h] = (tempArray[h] + 3);
                        probDist.set(i, tempArray);
                    }
                }
            }
        } else if(winner == 1){
            for(int n = 0; n < 9; n+=2){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = results[n][0];
                    if(tempCheckerOne == tempCheckerTwo){
                        int h = results[n][1];
                        tempArray[h] = (tempArray[h] + 5);
                        probDist.set(i, tempArray);
                    }
                }
            }
            for(int n = 1; n < 9; n+=2){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = results[n][0];
                    if(tempCheckerOne == tempCheckerTwo){
                        int h = results[n][1];
                        for(int j = 1; j < 10; j++){
                            if(j != h){
                                tempArray[j] = (tempArray[j] + 2);
                                probDist.set(i, tempArray);
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < 9; i++){
                done = false;
                if((results[i][0] == 0) && (done == false)){
                    winPoint = (i - 1);
                    done = true;
                }
            }
            if(done == false){
                done = true;
                winPoint = 8;
            }
            for(int i = 0; i < probDist.size(); i++){
                int[] tempArray = probDist.get(i);
                int tempCheckerTwo = tempArray[0];
                int tempCheckerOne = results[winPoint][0];
                if(tempCheckerOne == tempCheckerTwo){
                    int h = results[winPoint][1];
                    for(int j = 1; j < 10; j++){ 
                        if(j != h){
                            tempArray[j] = 0;
                            probDist.set(i, tempArray);
                        } else {
                            tempArray[j] = 1;
                            probDist.set(i, tempArray);
                        }
                        tempArray[j] = (tempArray[j] + 2);
                        probDist.set(i, tempArray);
                    }
                }
            }
        } else {
            for(int n = 1; n < 9; n+=2){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = results[n][0];
                    if(tempCheckerOne == tempCheckerTwo){
                        int h = results[n][1];
                        tempArray[h] = (tempArray[h] + 5);
                        probDist.set(i, tempArray);
                    }
                }
            }
            for(int n = 0; n < 9; n+=2){
                for(int i = 0; i < probDist.size(); i++){
                    int[] tempArray = probDist.get(i);
                    int tempCheckerTwo = tempArray[0];
                    int tempCheckerOne = results[n][0];
                    if(tempCheckerOne == tempCheckerTwo){
                        int h = results[n][1];
                        for(int j = 1; j < 10; j++){
                            if(j != h){
                                tempArray[j] = (tempArray[j] + 2);
                                probDist.set(i, tempArray);
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < 9; i++){
                done = false;
                if((results[i][0] == 0) && (done == false)){
                    winPoint = (i - 1);
                    done = true;
                }
            }
            if(done == false){
                done = true;
                winPoint = 8;
            }
            for(int i = 0; i < probDist.size(); i++){
                int[] tempArray = probDist.get(i);
                int tempCheckerTwo = tempArray[0];
                int tempCheckerOne = results[winPoint][0];
                if(tempCheckerOne == tempCheckerTwo){
                    int h = results[winPoint][1];
                    for(int j = 1; j < 10; j++){ 
                        if(j != h){
                            tempArray[j] = 0;
                            probDist.set(i, tempArray);
                        } else {
                            tempArray[j] = 1;
                            probDist.set(i, tempArray);
                        }
                        tempArray[j] = (tempArray[j] + 2);
                        probDist.set(i, tempArray);
                    }
                }
            }
        }
    }
    
    public void reset(){
        startYes = false;
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
        seven = 0;
        eight = 0;
        nine = 0;
        winner = 0;
        turn = 0;
        players = -1;
        turnNumber = 0;
    }
}
