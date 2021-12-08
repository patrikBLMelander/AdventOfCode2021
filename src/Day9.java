import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-08
 * Time: 11:44
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day9 {

    List<String> list = InputReader.readStringFile("test.txt");

    public Day9() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    private String problem2(List<String> list) {
        return null;
    }

    private String problem1(List<String> list) {
        return null;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day9 d = new Day9();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }
}
