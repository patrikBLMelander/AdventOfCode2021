import java.io.IOException;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-14
 * Time: 11:21
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day15 {
    List<String> list = InputReader.readStringFile("test.txt");


    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day15 d = new Day15();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public Day15() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    private int problem1(List<String> list) {
        return 0;
    }

    private int problem2(List<String> list) {
        return 0;
    }
}
