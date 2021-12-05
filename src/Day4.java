import java.util.List;
import java.util.*;

/**
 * Created by Patrik Melander
 * Date: 2021-12-05
 * Time: 19:05
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day4 {
    List<String> list = InputReader.readStringFile("day4.txt");



    public Day4() {

        System.out.println(problem1(list));
        System.out.println(problem2(list));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day4 d = new Day4();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public int problem1(List<String> list) {
        //Create Draw
        String[] draw  =list.get(0).split(",");


        //Create all gameboards
        List<GameBoard> gameBoards = new ArrayList<>();

        GameBoard gameBoard = new GameBoard();

        for (int i = 2; i < list.size(); i++) {
            String line = list.get(i);

            if (line.isBlank()) {
                gameBoards.add(gameBoard);
                gameBoard = new GameBoard();
            } else {
                String[] parts = line.split("[^\\d]+");
                gameBoard.gameBoard.addAll(Arrays.asList(parts));
            }
        }

        gameBoards.add(gameBoard);

        for (GameBoard g : gameBoards) {
            for (int i = 0; i <g.gameBoard.size() ; i++) {
                if (g.gameBoard.get(i).isBlank()){
                    g.gameBoard.remove(i);
                }
            }
        }

        int lastNr = 0;
        boolean winnerFound = false;
        while(!winnerFound){
            for (String s : draw) {
                for (GameBoard g : gameBoards) {
                    for (int i = 0; i <g.gameBoard.size() ; i++) {
                        if (g.gameBoard.get(i).equals(s)){
                            g.gameBoard.set(i, "x");
                            winnerFound = checkIfWon(i, g);
                            if(winnerFound){
                                lastNr=Integer.parseInt(s);
                                g.isWinner=true;
                                break;
                            }
                        }
                    }
                    if(winnerFound)break;
                }
                if(winnerFound)break;
            }
        }
        int sum=0;
        for (GameBoard g : gameBoards) {
            if(g.isWinner){
                for (String numbers: g.gameBoard) {
                    if (!numbers.equals("x")){
                        sum+=Integer.parseInt(numbers);
                    }
                }
            }
        }


        return sum * lastNr ;
    }

    public int problem2(List<String> list) {
        //Create Draw
        String[] draw  =list.get(0).split(",");


        //Create all gameboards
        List<GameBoard> gameBoards = new ArrayList<>();

        GameBoard gameBoard = new GameBoard();

        for (int i = 2; i < list.size(); i++) {
            String line = list.get(i);

            if (line.isBlank()) {
                gameBoards.add(gameBoard);
                gameBoard = new GameBoard();
            } else {
                String[] parts = line.split("[^\\d]+");
                gameBoard.gameBoard.addAll(Arrays.asList(parts));
            }
        }

        gameBoards.add(gameBoard);

        for (GameBoard g : gameBoards) {
            for (int i = 0; i <g.gameBoard.size() ; i++) {
                if (g.gameBoard.get(i).isBlank()){
                    g.gameBoard.remove(i);
                }
            }
        }
        int sum=0;
        int lastNr = 0;
        boolean allWinnersFound = false;
        while(!allWinnersFound){
            for (String s : draw) {
                for (GameBoard g : gameBoards) {
                    for (int i = 0; i <g.gameBoard.size() ; i++) {
                        if (g.gameBoard.get(i).equals(s)&&!g.isWinner){
                            g.gameBoard.set(i, "x");
                            g.isWinner= checkIfWon(i, g);
                            if(g.isWinner){
                                allWinnersFound = checkIfAllWon(gameBoards);
                                if(allWinnersFound){
                                    lastNr=Integer.parseInt(s);
                                    for (String numbers: g.gameBoard) {
                                        if (!numbers.equals("x")){
                                            sum+=Integer.parseInt(numbers);
                                        }
                                    }

                                }
                                    break;
                            }
                        }
                    }
                    if(allWinnersFound)break;
                }
                if(allWinnersFound)break;
            }

        }





        return sum * lastNr ;
    }

    public boolean checkIfWon(int index, GameBoard gameBoard){
        //checkHorizon
        if(index==0||index==5||index==10||index==15||index==20){
            if(gameBoard.gameBoard.get(index + 1).equals("x")
                    && gameBoard.gameBoard.get(index + 2).equals("x")
                    && gameBoard.gameBoard.get(index + 3).equals("x")
                    && gameBoard.gameBoard.get(index + 4).equals("x")){
                return true;
            }else return checkVertical(index, gameBoard);
        }else if(index==1||index==6||index==11||index==16||index==21) {
            if(gameBoard.gameBoard.get(index - 1).equals("x")
                    && gameBoard.gameBoard.get(index + 1).equals("x")
                    && gameBoard.gameBoard.get(index + 2).equals("x")
                    && gameBoard.gameBoard.get(index + 3).equals("x")){
                return true;
            }else return checkVertical(index, gameBoard);
        }else if(index==2||index==7||index==12||index==17||index==22) {
            if(gameBoard.gameBoard.get(index - 2).equals("x")
                    && gameBoard.gameBoard.get(index - 1).equals("x")
                    && gameBoard.gameBoard.get(index + 1).equals("x")
                    && gameBoard.gameBoard.get(index + 2).equals("x")){
                return true;
            }else return checkVertical(index, gameBoard);
        }else if(index==3||index==8||index==13||index==18||index==23) {
            if(gameBoard.gameBoard.get(index - 3).equals("x")
                    && gameBoard.gameBoard.get(index - 2).equals("x")
                    && gameBoard.gameBoard.get(index - 1).equals("x")
                    && gameBoard.gameBoard.get(index + 1).equals("x")){
                return true;
            }else return checkVertical(index, gameBoard);
        }else if(index==4||index==9||index==14||index==19||index==24) {
            if (gameBoard.gameBoard.get(index - 4).equals("x")
                    && gameBoard.gameBoard.get(index - 3).equals("x")
                    && gameBoard.gameBoard.get(index - 2).equals("x")
                    && gameBoard.gameBoard.get(index - 1).equals("x")) {
                return true;
            } else return checkVertical(index, gameBoard);

        }
        return false;
    }

    public boolean checkVertical(int index, GameBoard gameBoard) {

        if(index==0||index==1||index==2||index==3||index==4){
            if(gameBoard.gameBoard.get(index + 5).equals("x")
                    && gameBoard.gameBoard.get(index + 10).equals("x")
                    && gameBoard.gameBoard.get(index + 15).equals("x")
                    && gameBoard.gameBoard.get(index + 20).equals("x")){
                return true;
            }else return false;
        }else if(index==5||index==6||index==7||index==8||index==9){
            if(gameBoard.gameBoard.get(index + 5).equals("x")
                    && gameBoard.gameBoard.get(index + 10).equals("x")
                    && gameBoard.gameBoard.get(index + 15).equals("x")
                    && gameBoard.gameBoard.get(index -5).equals("x")){
                return true;
            }else return false;
        }else if(index==10||index==11||index==12||index==13||index==14){
            if(gameBoard.gameBoard.get(index + 5).equals("x")
                    && gameBoard.gameBoard.get(index + 10).equals("x")
                    && gameBoard.gameBoard.get(index - 10).equals("x")
                    && gameBoard.gameBoard.get(index -5).equals("x")){
                return true;
            }else return false;
        }else if(index==15||index==16||index==17||index==18||index==19){
            if(gameBoard.gameBoard.get(index + 5).equals("x")
                    && gameBoard.gameBoard.get(index - 15).equals("x")
                    && gameBoard.gameBoard.get(index - 10).equals("x")
                    && gameBoard.gameBoard.get(index -5).equals("x")){
                return true;
            }else return false;
        }else if(index==20||index==21||index==22||index==23||index==24){
            if(gameBoard.gameBoard.get(index - 20).equals("x")
                    && gameBoard.gameBoard.get(index - 15).equals("x")
                    && gameBoard.gameBoard.get(index - 10).equals("x")
                    && gameBoard.gameBoard.get(index -5).equals("x")){
                return true;
            }else return false;
        }

        return false;
    }

    public boolean checkIfAllWon(List<GameBoard> gameBoards){
        int winnerCounter = 0;

        for (GameBoard g : gameBoards) {

            if (g.isWinner) {
                winnerCounter++;
            }
        }

        return winnerCounter == gameBoards.size();
    }

    public class GameBoard{
        List<String> gameBoard = new ArrayList<>();
        boolean isWinner = false;
    }




}
