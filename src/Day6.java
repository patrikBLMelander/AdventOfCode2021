import java.util.ArrayList;

import java.util.List;


/**
 * Created by Patrik Melander
 * Date: 2021-12-05
 * Time: 22:55
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day6 {
    List<String> list = InputReader.readStringFile("day6.txt");
    Timer timer = new Timer();

    public Day6() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args) {
        Day6 d = new Day6();
    }


    public int problem1(List<String> list) {
        timer.startTimer();
        String[] parts = new String[999];
        List<Integer> lanternFiches =new ArrayList<>();
        for (String s: list) {
           parts = s.split("," );
        }
        for (String s: parts) {
            lanternFiches.add(Integer.parseInt(s));
        }
        int dayCounter = 0;

        while (dayCounter<80) {
            List<Integer> newDayLanternFiches = lanternFiches;
            lanternFiches=new ArrayList<>();
            for (Integer newDayLanternFish : newDayLanternFiches) {
                int tempValue = newDayLanternFish - 1;


                if (newDayLanternFish == 0) {
                    tempValue = 6;
                    lanternFiches.add(tempValue);
                    Integer newFish = 8;
                    lanternFiches.add(newFish);
                } else {
                    lanternFiches.add(tempValue);
                }
            }
            dayCounter++;
        }
        timer.stopTimer("Day6", "Problem1");
        return lanternFiches.size();
    }

    public long problem2(List<String> list) {
        timer.startTimer();

        for (String s : list) {
            String[] startQuantity = s.split(",");

            long[] lanternFiches = new long[9];

            long temp;

            for (String value : startQuantity) {
                lanternFiches[Integer.parseInt(value)]++;
            }

            for (int i = 0; i < 256; i++) {
                temp = lanternFiches[0];
                lanternFiches[0] = lanternFiches[1];
                lanternFiches[1] = lanternFiches[2];
                lanternFiches[2] = lanternFiches[3];
                lanternFiches[3] = lanternFiches[4];
                lanternFiches[4] = lanternFiches[5];
                lanternFiches[5] = lanternFiches[6];
                lanternFiches[6] = temp + lanternFiches[7];
                lanternFiches[7] = lanternFiches[8];
                lanternFiches[8] = temp;
            }
            timer.stopTimer("Day6", "Problem2");
            return lanternFiches[0] + lanternFiches[1] + lanternFiches[2] + lanternFiches[3] + lanternFiches[4] + lanternFiches[5] + lanternFiches[6] + lanternFiches[7] + lanternFiches[8];
        }
        return 0;
    }
}
