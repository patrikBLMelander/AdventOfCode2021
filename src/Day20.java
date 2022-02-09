import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-20
 * Time: 08:45
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day20 {
    List<String> list = InputReader.readStringFile("day20.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day20 d = new Day20();
    }

    public Day20() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private String problem1(List<String> list) {
        timer.startTimer();



        timer.stopTimer("Day20", "Problem1");
        return null;
    }

    private String problem2(List<String> list) {
        timer.startTimer();

        timer.stopTimer("Day20", "Problem2");

        return null;
    }



}

