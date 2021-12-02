import java.io.IOException;
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

    public Day2() {
        System.out.println(problem1(list));
        System.out.println(problem2(list));
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day2 d = new Day2();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }



    public static int problem1(List<String> list) {
        int deapth =0;
        int horizon=0;

        for (String s : list) {
            String[] parts = s.split(" ", 2);

                    switch (parts[0]) {
                case "up" -> deapth -= Integer.parseInt(parts[1]);
                case "down" -> deapth += Integer.parseInt(parts[1]);
                case "forward" -> horizon += Integer.parseInt(parts[1]);
            }
        }
        return deapth*horizon;

    }

    public static int problem2(List<String> list) {
        int depth =0;
        int horizon=0;
        int aim=0;

        for (String s : list) {
            String[] parts = s.split(" ", 2);

            switch (parts[0]) {
                case "up" -> {aim -= Integer.parseInt(parts[1]);}
                case "down" -> {aim += Integer.parseInt(parts[1]);}
                case "forward" -> {horizon += Integer.parseInt(parts[1]);
                                depth+=aim*Integer.parseInt(parts[1]);}
            }
        }
        return depth*horizon;
    }
}
