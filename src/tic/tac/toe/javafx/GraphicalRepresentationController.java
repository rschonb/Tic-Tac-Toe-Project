package tic.tac.toe.javafx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author GG_MacAir
 */
public class GraphicalRepresentationController implements Initializable {

    @FXML
    private PieChart piechart;
    
    @FXML
    private Button backButton;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int wins = 0;
        int losses = 0;
        ArrayList<Boolean> dataList = Settings.getWins();
        for(boolean b : dataList){
             if(b == true){
                 wins++;
             }else{
                 losses++;
             }
            
            
        }
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Wins", wins),
                new PieChart.Data("Looses", losses));
                
        piechart = new PieChart(pieChartData);

        
    }    
    
}
