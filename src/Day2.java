
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-02
 * Time: 07:03
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day2 {

    List<String> list = InputReader.readStringFile("day2.txt");
    Timer timer = new Timer();

    public Day2() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args){
        Day2 d = new Day2();
    }



    public int problem1(List<String> list) {
        timer.startTimer();
        int depth =0;
        int horizon=0;

        for (String s : list) {
            String[] parts = s.split(" ", 2);

                    switch (parts[0]) {
                case "up" -> depth -= Integer.parseInt(parts[1]);
                case "down" -> depth += Integer.parseInt(parts[1]);
                case "forward" -> horizon += Integer.parseInt(parts[1]);
            }
        }
        timer.stopTimer("Day2", "Problem1");
        return depth*horizon;

    }

    public int problem2(List<String> list) {
        timer.startTimer();
        int depth =0;
        int horizon=0;
        int aim=0;

        for (String s : list) {
            String[] parts = s.split(" ", 2);

            switch (parts[0]) {
                case "up" -> aim -= Integer.parseInt(parts[1]);
                case "down" -> aim += Integer.parseInt(parts[1]);
                case "forward" -> {horizon += Integer.parseInt(parts[1]);
                                depth+=aim*Integer.parseInt(parts[1]);}
            }
        }
        timer.stopTimer("Day2", "Problem2");
        return depth*horizon;
    }
}
