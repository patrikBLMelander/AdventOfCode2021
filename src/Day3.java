import java.io.IOException;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-02
 * Time: 08:48
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day3 {
    List<String> list = InputReader.readStringFile("test.txt");
    public Day3() {
        System.out.println(problem1(list));
        System.out.println(problem2(list));
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day3 d = new Day3();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }



    public static int problem1(List<String> list) {
        return 0;
    }

    public static int problem2(List<String> list) {

        return 0;
    }
}
