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
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day15 d = new Day15();
    }

    public Day15() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private int problem1(List<String> list) {
        timer.startTimer();
        timer.stopTimer("Day14", "Problem1");
        return 0;
    }

    private int problem2(List<String> list) {
        timer.startTimer();
        timer.stopTimer("Day14", "Problem2");
        return 0;
    }
}
