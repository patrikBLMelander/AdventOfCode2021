import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class Day11 {

    List<String> list = InputReader.readStringFile("day11.txt");
    Timer timer = new Timer();

    public static void main(String[] args) throws IOException {
        Day11 d = new Day11();
    }

    public Day11() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    private int problem1(List<String> list) {
        timer.startTimer();

        int[][] octopuses = new int[list.size()][list.get(0).length()];
        for(int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            for(int j = 0; j < s.length(); j++)
                octopuses[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }

        int flashes = 0;
        for(int step = 0; step < 100; step++) {
            int flashesInThisStep = 0;
            for(int i = 0; i < octopuses.length; i++) {
                for(int j = 0; j < octopuses[i].length; j++) {
                    List<Point> toVisit = new ArrayList<>();
                    toVisit.add(new Point(i, j));
                    while(toVisit.size() > 0) {
                        Point p = toVisit.remove(0);
                        octopuses[p.row][p.col] += 1;
                        if(octopuses[p.row][p.col] == 10) {
                            flashesInThisStep++;
                            if(p.row - 1 >= 0)
                                toVisit.add(new Point(p.row - 1, p.col));
                            if(p.row - 1 >= 0 && p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row - 1, p.col + 1));
                            if(p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row, p.col + 1));
                            if(p.row + 1 < octopuses.length && p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row + 1, p.col + 1));
                            if(p.row + 1 < octopuses.length)
                                toVisit.add(new Point(p.row + 1, p.col));
                            if(p.row + 1 < octopuses.length && p.col - 1 >= 0)
                                toVisit.add(new Point(p.row + 1, p.col - 1));
                            if(p.col - 1 >= 0)
                                toVisit.add(new Point(p.row, p.col - 1));
                            if(p.row - 1 >= 0 && p.col - 1 >= 0)
                                toVisit.add(new Point(p.row - 1, p.col - 1));
                        }
                    }
                }
            }
            flashes += flashesInThisStep;
            for(int i = 0; i < octopuses.length; i++)
                for(int j = 0; j < octopuses[i].length; j++)
                    if(octopuses[i][j] > 9)
                        octopuses[i][j] = 0;

        }

        timer.stopTimer("Day11", "Problem1");
        return flashes;
    }

    private int problem2(List<String> list) {
        int steps = 0;

        int[][] octopuses = new int[list.size()][list.get(0).length()];
        for(int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            for(int j = 0; j < s.length(); j++)
                octopuses[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }

        boolean isNotFlashedAllTogether=true;
        while(isNotFlashedAllTogether) {
            steps++;
            for(int i = 0; i < octopuses.length; i++) {
                for(int j = 0; j < octopuses[i].length; j++) {
                    List<Point> toVisit = new ArrayList<>();
                    toVisit.add(new Point(i, j));
                    while(toVisit.size() > 0) {
                        Point p = toVisit.remove(0);
                        octopuses[p.row][p.col] += 1;
                        if(octopuses[p.row][p.col] == 10) {
                            if(p.row - 1 >= 0)
                                toVisit.add(new Point(p.row - 1, p.col));
                            if(p.row - 1 >= 0 && p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row - 1, p.col + 1));
                            if(p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row, p.col + 1));
                            if(p.row + 1 < octopuses.length && p.col + 1 < octopuses[p.row].length)
                                toVisit.add(new Point(p.row + 1, p.col + 1));
                            if(p.row + 1 < octopuses.length)
                                toVisit.add(new Point(p.row + 1, p.col));
                            if(p.row + 1 < octopuses.length && p.col - 1 >= 0)
                                toVisit.add(new Point(p.row + 1, p.col - 1));
                            if(p.col - 1 >= 0)
                                toVisit.add(new Point(p.row, p.col - 1));
                            if(p.row - 1 >= 0 && p.col - 1 >= 0)
                                toVisit.add(new Point(p.row - 1, p.col - 1));
                        }
                    }
                }
            }
            for (int[] octopus : octopuses) {
                for (int i : octopus) {
                    if (i > 9) {
                        isNotFlashedAllTogether = false;
                    } else {
                        isNotFlashedAllTogether = true;
                        break;
                    }
                }
            }

            for(int i = 0; i < octopuses.length; i++) {
                for (int j = 0; j < octopuses[i].length; j++) {
                    if (octopuses[i][j] > 9)
                        octopuses[i][j] = 0;
                }
            }
        }
        timer.stopTimer("Day11", "Problem2");
        return steps;
    }
}