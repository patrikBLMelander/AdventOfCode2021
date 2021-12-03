
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-01
 * Time: 18:32
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day4 {

    List<Integer> list = InputReader.readIntegerFile("test.txt");

    public Day4() {
        System.out.println(problem1(list));
        System.out.println(problem2(list));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day4 d = new Day4();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public static int problem1(List<Integer> list) {

        return 0;

    }

    public static int problem2(List<Integer> list) {

        return 0;
    }

}
