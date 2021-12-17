import java.io.IOException;
import java.util.*;


/**
 * Created by Patrik Melander
 * Date: 2021-12-17
 * Time: 11:21
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day17 {
    List<String> list = InputReader.readStringFile("day17.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day17 d = new Day17();
    }

    public Day17() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private int problem1(List<String>list) {
        timer.startTimer();
        int positionX = 0;
        int positionY = 0;

        String[] parts = list.get(0).replace("target area: x=", "").replace(" y=", "").split(",");
        int minX = Integer.parseInt(parts[0].split("\\.\\.")[0]);
        int maxX = Integer.parseInt(parts[0].split("\\.\\.")[1]);
        int minY = Integer.parseInt(parts[1].split("\\.\\.")[0]);
        int maxY = Integer.parseInt(parts[1].split("\\.\\.")[1]);

        int answer =Integer.MIN_VALUE;

        for (int x = maxX; x >0 ; x--) {
            int ShotDirectionX=x;
            positionX =0;
            for (int y =150; y >=0 ; y--) {
                int highestPoint=0;
                positionY=0;
                int ShotDirectionY=y;
                while (true){
                    positionX += ShotDirectionX;
                    positionY += ShotDirectionY;
                    if (highestPoint<positionY){
                        highestPoint=positionY;
                    }

                    if (ShotDirectionX>0){
                        ShotDirectionX -=1;
                    }
                    ShotDirectionY -=1;

                    if (positionX>=minX&&positionX<=maxX){
                        if(positionY>=minY&&positionY<=maxY){
                            if (answer<highestPoint){
                                answer=highestPoint;
                            }
                            break;
                        }
                    }

                    if (positionX>maxX||positionY<minY){

                        break;
                    }
                }
            }
        }
        timer.stopTimer("Day17", "Problem1");
        return answer;
    }

    private int problem2(List<String> list) {
             timer.startTimer();

    String[] parts = list.get(0).replace("target area: x=", "").replace(" y=", "").split(",");
    int minX = Integer.parseInt(parts[0].split("\\.\\.")[0]);
    int maxX = Integer.parseInt(parts[0].split("\\.\\.")[1]);
    int minY = Integer.parseInt(parts[1].split("\\.\\.")[0]);
    int maxY = Integer.parseInt(parts[1].split("\\.\\.")[1]);

    int hitTarget = 0;
        for(int y = minY; y < 115; y++) {
            for(int x = 0; x < maxX + 1; x++) {
                int ShotDirectionX = x;
                int ShotDirectionY=y;
                int positionX = 0;
                int positionY = 0;

                while(true)
                {
                    positionX += ShotDirectionX;
                    positionY += ShotDirectionY;

                    if(minX <= positionX && maxX >= positionX && minY <= positionY && maxY >= positionY){
                        hitTarget++;
                    }else if(minY > positionY){
                        break;
                    }
                    if (positionX>0){
                        ShotDirectionX -=1;
                    }
                    if (positionX<0){
                        ShotDirectionX +=1;
                    }
                    ShotDirectionY -= 1;
                }
            }
        }
        timer.stopTimer("Day17", "Problem2");
        return hitTarget;

    }
        // 3767 is correct

}
