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
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day13 d = new Day13();
    }

    public Day13() {
    problem1(list);
        System.out.println("Answer: " + problem1(list));
        problem2(list);

    }
    private int problem1(List<String> list) {
        timer.startTimer();

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
                timer.stopTimer("Day13", "Problem1");
                return marks.size();
            }

        }
        return 0;
    }

    private void problem2(List<String> list) {
        timer.startTimer();

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

        for(int row = 0; row <= maxRow; row++) {
            for(int col = 0; col <= maxCol; col++)
                System.out.print(marks.contains(new Point(row, col)) ? "#" : " ");
            System.out.println();
        }
        timer.stopTimer("Day13", "Problem2");

    }

}
