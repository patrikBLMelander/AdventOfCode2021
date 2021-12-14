
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
    Timer timer = new Timer();

    public Day1() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args) {
        Day1 d = new Day1();
    }

    public int problem1(List<Integer> list) {
        timer.startTimer();
        int increased=0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1)<list.get(i)){
                increased++;
            }
        }
        timer.stopTimer("Day1", "Problem1");
        return increased;

    }

    public int problem2(List<Integer> list) {
        timer.startTimer();
        int increased=0;
        for (int i = 3; i < list.size(); i++) {
            if (list.get(i-1)+list.get(i-2)+list.get(i-3)<list.get(i)+list.get(i-1)+list.get(i-2)){
                increased++;
            }
        }
        timer.stopTimer("Day1", "Problem2");
        return increased;
    }

}
