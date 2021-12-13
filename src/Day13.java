import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-13
 * Time: 08:37
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day13 {
    List<String> list = InputReader.readStringFile("day13.txt");


    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day13 d = new Day13();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public Day13() {
    problem1(list);
        //Part 1 answer 755
        //System.out.println("Answer Problem 2: " + problem2(list));
    }



    private void problem1(List<String> list) {

        List<Point> marks = new ArrayList<>();

        boolean endOfPoints = true;
        for (String s : list) {
            if(s.equals("")) {
                endOfPoints = false;
                continue;
            }
            if (endOfPoints) {
                String[] pos = s.split(",");
                marks.add(new Point(Integer.parseInt(pos[1]), Integer.parseInt(pos[0])));
            }else {
                String[] parts = s.replace("fold along ", "").split("=");
                int line = Integer.parseInt(parts[1]);
                for(int i = marks.size() - 1; i >= 0; i--){
                    Point p = marks.get(i);
                    if(parts[0].equals("x")) {
                        if(p.col > line) {
                            int newX = line - (p.col - line);
                            if(marks.contains(new Point(p.row, newX)))
                                marks.remove(i);
                            else
                                p.col = line - (p.col - line);
                        }
                    }
                    else{
                        if(p.row > line){
                            int newY = line - (p.row - line);
                            if(marks.contains(new Point(newY, p.col)))
                                marks.remove(i);
                            else
                                p.row = line - (p.row - line);
                        }
                    }
                }
                System.out.println("Answer problem one: " + marks.size());
            }

        }
        int maxCol = -1;
        int maxRow = -1;

        for(Point p : marks)
        {
            if(p.row > maxRow)
                maxRow = p.row;
            if(p.col > maxCol)
                maxCol = p.col;
        }

        for(int row = 0; row <= maxRow; row++)
        {
            for(int col = 0; col <= maxCol; col++)
                System.out.print(marks.contains(new Point(row, col)) ? "#" : " ");
            System.out.println();
        }

    }

    private int problem2(List<String> list) {
        return 0;
    }

}
