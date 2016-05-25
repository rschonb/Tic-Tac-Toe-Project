package tic.tac.toe.javafx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tic.tac.toe.javafx.Settings;

/**
 *
 * @author GG_MacAir
 */
public class TicTacToeJavaFX extends Application {
    
    private static TicTacToeJavaFX appInstance;
    private Stage mainWindow;
    
    public static TicTacToeJavaFX getAppInstance() {
        return appInstance;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.appInstance = this;
        this.mainWindow = stage;
        showGameView();
    }
    /*
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBoardGame.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    */
    @Override
    public void stop() {
        Settings.save();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    public void showGraphView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GraphicalRepresentation.fxml"));
        
        Scene scene = new Scene(root);
        
        //scene.getStylesheets().add(getClass().getResource("graphicalrepresentation.css").toExternalForm());
        
        this.mainWindow.setScene(scene);
        this.mainWindow.show();        
    }

    public void showGameView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBoardGame.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        
        this.mainWindow.setScene(scene);
        this.mainWindow.show();
    }
}
