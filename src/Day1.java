
import java.io.IOException;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-01
 * Time: 18:32
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day1 {

    List<Integer> list = InputReader.readIntegerFile("day1.txt");

    public Day1() {
        System.out.println(day1Problem1(list));
        System.out.println(day1Problem2(list));
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day1 d = new Day1();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public static int day1Problem1(List<Integer> list) {
        int increased=0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1)<list.get(i)){
                increased++;
            }
        }
        return increased;

    }

    public static int day1Problem2(List<Integer> list) {
        int increased=0;
        for (int i = 3; i < list.size(); i++) {
            if (list.get(i-1)+list.get(i-2)+list.get(i-3)<list.get(i)+list.get(i-1)+list.get(i-2)){
                increased++;
            }
        }
        return increased;
    }

}
