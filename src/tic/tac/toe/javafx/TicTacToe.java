/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.javafx;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GG_MacAir
 */
public class TicTacToe {
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
    
    
    
    public TicTacToe(){
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
    
    
    
    
    public void start(int tempPlayers){
        probDist = Settings.getList();
        tempA = players;
        reset();
        players = tempA;
        //THIS CLEARS THE BOARD
        players = tempPlayers;
        if(players == 10000){
            for(int i = 0; i < 500000; i++){
                this.runGame();
            }
            saveData();
        }
        if(players < 0 || players > 2){
            System.out.print("\f");
            //THIS CLEARS THE BOARD
            System.out.println("Choose 1 or 2 players, or run a training program with 0.");
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
        System.out.print("\f");
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
        System.out.print("\f");
        //THIS CLEARS THE BOARD
        attributeSquare();
        printBoard();
    }
    
    public void pickSquareUser(){
        check = false;
        while(check == false){
            //ALL OF THIS WILL NEED TO BE CHANGED FOR USER INPUT
            
            Scanner in = new Scanner(System.in);
            System.out.printf("Pick a space, 1-9: ");
            int i = in.nextInt();
            square = i;
            if((square < 0) || (square > 9)){
                check = false;
            } else if(square == 0){
                reset();
                System.exit(1);
            } else {
                check = true;
            }
            checkPicked();
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
            if(square == 1){
                one = 1;
            } else if(square == 2){
                two = 1;
            } else if(square == 3){
                three = 1;
            } else if(square == 4){
                four = 1;
            } else if(square == 5){
                five = 1;
            } else if(square == 6){
                six = 1;
            } else if(square == 7){
                seven = 1;
            } else if(square == 8){
                eight = 1;
            } else {
                nine = 1;
            }
        }
        if(turn == 2){
            if(square == 1){
                one = 2;
            } else if(square == 2){
                two = 2;
            } else if(square == 3){
                three = 2;
            } else if(square == 4){
                four = 2;
            } else if(square == 5){
                five = 2;
            } else if(square == 6){
                six = 2;
            } else if(square == 7){
                seven = 2;
            } else if(square == 8){
                eight = 2;
            } else {
                nine = 2;
            }
        }
        if(turn == 1){
            turn = 2;
        } else {
            turn = 1;
        }
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
    
    //THIS IS BASICALLY THE ONE RUNNING AT ALL TIMES.
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
    
    /*
    public void checkWinnerFake(){
        if(winner == 0){
            System.out.println("It's a tie! Press enter to play again.");
            start(players);
        } else if(winner == 1){
            System.out.println("X wins! Press enter to play again.");
            start(players);
        } else {
            System.out.println("O wins! Press enter to play again.");
            start(players);
        }
    }
    */
    
    public void checkWinner(){
        if(winner == 0){
            if(players == 0){
                runCompensation();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("It's a tie! Press enter to play again.");
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
            System.out.println("X wins! Press enter to play again.");
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
            System.out.println("O wins! Press enter to play again.");
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
