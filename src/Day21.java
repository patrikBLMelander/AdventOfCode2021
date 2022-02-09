import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-21
 * Time: 08:33
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day21 {
    List<String> list = InputReader.readStringFile("day21.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day21 d = new Day21();
    }

    public Day21() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private int problem1(List<String> list) {
        timer.startTimer();
        List<String> startingPosition=new ArrayList<>();
        for (String s : list) {
            int temp=  s.indexOf(':');
            startingPosition.add(s.substring(temp+1));
        }
        int player1Position = Integer.parseInt(startingPosition.get(0));
        int player2Position = Integer.parseInt(startingPosition.get(1));

        int player1Score = 0;
        int player2Score = 0;

        int rollCounter = 0;

        int looserScore=0;
        int dice=1;
        boolean noWinner = true;
        boolean firstPlayersTurn = true;
        while (noWinner){
            if (firstPlayersTurn) {

                int stepsThisRoll= calculateSteps(rollDice(dice));
                dice+=3;
                if (dice>100){
                    dice-=100;
                }
                rollCounter+=3;
                player1Position = takeSteps(stepsThisRoll, player1Position);

                player1Score+=player1Position;

                noWinner=checkWinner(player1Score);
                firstPlayersTurn=false;
            }else{

                int stepsThisRoll= calculateSteps(rollDice(dice));
                dice+=3;
                if (dice>100){
                    dice-=100;
                }
                rollCounter+=3;
                player2Position = takeSteps(stepsThisRoll, player2Position);

                player2Score+=player2Position;

                noWinner=checkWinner(player2Score);
                firstPlayersTurn=true;
            }

            if (!noWinner){
                looserScore = checkWinnerScore(player1Score, player2Score);
            }



        }
        System.out.println(looserScore);
        System.out.println(rollCounter);

        timer.stopTimer("Day21", "Problem1");
        return looserScore*rollCounter;
    }



    private String problem2(List<String> list) {
        timer.startTimer();

        timer.stopTimer("Day21", "Problem2");

        return null;
    }
    public int calculateSteps(int dice){
        int steps = dice;
        if (steps>10){
            steps= steps%10;
        }
        return steps;
    }
    public int rollDice(int dice){
        int newDice = dice;
        if (dice+1>100){
            dice-=100;
        }
        newDice += dice+1;
        if (dice+2>100){
            dice-=100;
        }
        newDice += dice+2;
        return newDice;
    }
    public int takeSteps(int steps,int currentPosition){
        currentPosition +=steps;
        if (currentPosition>10){
            currentPosition-=10;
        }
        return currentPosition;
    }

    public boolean checkWinner (int score){
        return score < 1000;
    }

    private int checkWinnerScore(int player1Score, int player2Score) {
        return Math.min(player1Score, player2Score);
    }

}
