/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.javafx;

/**
 *
 * @author GG_MacAir
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dwheadon
 */
public class Settings implements java.io.Serializable {
    private ArrayList<Boolean> wins = new ArrayList<Boolean>();
    private ArrayList<int[]> probDist = new ArrayList<int[]>();
    public transient static Settings instance;
    
    
    
    private Settings() {}
    
    private static void init() {
        if (instance == null) {
            try
            {
               FileInputStream fileIn = new FileInputStream("settings.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               instance = (Settings) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i)
            {
               instance = new Settings();
               return;
            }catch(ClassNotFoundException c)
            {
               System.out.println("Employee class not found");
               c.printStackTrace();
               return;
            }            
        }
    }
    
    public static ArrayList<int[]> getList() {
        init();
        return instance.probDist;
    }
    
    public static void setList(ArrayList<int[]> data) {
        init();
        instance.probDist = data;
    }
    
    public static ArrayList<Boolean> getWins() {
        init();
        return instance.wins;
    }
    
    public static void setWins(ArrayList<Boolean> data) {
        init();
        instance.wins = data;
    }
    
    public static void save() {
        init();
        try {
           FileOutputStream fileOut =
           new FileOutputStream("settings.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(instance);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in settings.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }    
    }
}