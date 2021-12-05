import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-05
 * Time: 22:55
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day6 {
    List<String> list = InputReader.readStringFile("day3.txt");

    public Day6() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day6 d = new Day6();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }


    public static int problem1(List<String> list) {

        return 0;
    }

    public static int problem2(List<String> list) {

        return 0;
    }

}
