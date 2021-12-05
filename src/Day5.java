
import java.sql.SQLOutput;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-02
 * Time: 07:03
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day5 {

    List<String> list = InputReader.readStringFile("day5.txt");

    public Day5() {
        //System.out.println(problem1(list));
        System.out.println(problem2(list));
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();

        Day5 d = new Day5();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }



    public int problem1(List<String> list) {
        int x1;
        int y1;
        int x2;
        int y2;
        int [][] mineField= new int[999][999];

        for (String s: list) {
            String[] parts = s.split(",| " );

                x1 = Integer.parseInt(parts[0]);
                y1 = Integer.parseInt(parts[1]);
                x2 = Integer.parseInt(parts[3]);
                y2 = Integer.parseInt(parts[4]);

                if(x1==x2){
                    System.out.println("x1==x2");
                    if(y1<y2){
                        for (int i = y1; i <= y2; i++) {
                            mineField[x1][i] = mineField[x1][i] +1;
                        }

                    }else{
                        for (int i = y2; i <= y1; i++) {
                            mineField[x1][i] = mineField[x1][i] +1;
                        }

                    }

                }else if (y1==y2){
                    System.out.println("y1==y2");
                    if(x1<x2){
                        for (int i = x1; i <= x2; i++) {
                            mineField[i][y1] = mineField[i][y1] +1;
                        }

                    }else{
                        for (int i = x2; i <= x1; i++) {
                            mineField[i][y1] = mineField[i][y1] +1;
                        }

                    }

                }
        }

       return countIntersections(mineField);

    }

    public int problem2(List<String> list) {
        int x1;
        int y1;
        int x2;
        int y2;
        int startX;
        int endX;
        int startY;
        int endY;
        int [][] mineField= new int[999][999];

        for (String s: list) {
            String[] parts = s.split(",| " );

            x1 = Integer.parseInt(parts[0]);
            y1 = Integer.parseInt(parts[1]);
            x2 = Integer.parseInt(parts[3]);
            y2 = Integer.parseInt(parts[4]);

            if(x1<x2){
                startX = x1;
                endX =x2;
            }else{
                startX = x2;
                endX =x1;
            }
            if(y1<y2){
                startY = y1;
                endY =y2;
            }else{
                startY = y2;
                endY =y1;
            }

            if(startX==endX){

                    for (int i = startY; i <= endY; i++) {
                        mineField[startX][i] = mineField[endX][i] +1;
                    }


            }else if (startY==endY){

                    for (int i = startX; i <= endX; i++) {
                        mineField[i][startY] = mineField[i][endY] +1;
                    }




            }else{
                int diaginalStepsX = endX-startX;

                if(x1<x2 && y1<y2){
                    for (int i = 0; i <= diaginalStepsX; i++) {
                        mineField[startX + i][startY + i] = mineField[startX + i][startY + i] + 1;
                    }
                }else if(x1>x2 && y1<y2){
                        for (int i = 0; i <= diaginalStepsX; i++) {
                            mineField[x1-i][startY+i] = mineField[x1-i][startY+i] +1;

                        }

                }if(x1<x2 && y1>y2){
                        for (int i = 0; i <= diaginalStepsX; i++) {
                            mineField[startX+i][y1-i] = mineField[startX+i][y1-i] +1;

                        }

                }if(x1>x2 && y1>y2){
                    for (int i = 0; i <= diaginalStepsX; i++) {
                        mineField[x1-i][y1-i] = mineField[x1-i][y1-i] +1;

                    }

                }

            }



        }
        //printPattern(mineField);
        return countIntersections(mineField);
    }

    private void printPattern(int[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print(" "+ (grid[x][y] == 0 ? "." : grid[x][y]));
            }
            System.out.println();
        }
        System.out.println();
    }
    private int countIntersections(int[][] grid) {
        int result = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] > 1) {
                    result++;
                }
            }
        }

        return result;
    }

}

