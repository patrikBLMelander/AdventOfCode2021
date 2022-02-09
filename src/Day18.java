import java.io.IOException;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-18
 * Time: 17:02
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day18 {
    List<String> list = InputReader.readStringFile("day17.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day18 d = new Day18();
    }

    public Day18() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private String problem1(List<String> list) {
        timer.startTimer();

        timer.stopTimer("Day18", "Problem1");
        return null;
    }

    private String problem2(List<String> list) {
        timer.startTimer();

        timer.stopTimer("Day18", "Problem2");

        return null;
    }



}
