package tic.tac.toe.javafx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.chart.BarChart;
/**
 * FXML Controller class
 *
 * @author GG_MacAir
 */
public class GraphicalRepresentationController implements Initializable {

    @FXML
    private BarChart chart;
    
    @FXML
    private Button backButton;
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hey");
        int wins = 0;
        int losses = 0;
        ArrayList<Boolean> dataList = Settings.getWins();
        for(Boolean b : dataList){
             if(b == true){
                 wins++;
             }else{
                 losses++;
             }
            
            
        }
        
       XYChart.Series<String, Number> Data = new XYChart.Series();
        Data.setName("Winning Vs. Losing");
        
        Data.getData().add(new XYChart.Data("Wins", wins));
        Data.getData().add(new XYChart.Data("Losses", losses));
        
        chart.getData().add(Data);
        
        
        
        
        
        

        
    }    
    
    
    
    @FXML
    public void handleBackToGraph() {
        try {
            TicTacToeJavaFX.getAppInstance().showGameView();
        } catch (IOException ex) {
            //Logger.getLogger(FXMLBoardGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
