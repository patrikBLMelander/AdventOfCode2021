import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Patrik Melander
 * Date: 2021-12-06
 * Time: 22:05
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day7 {
    List<String> list = InputReader.readStringFile("day7.txt");
    Timer timer = new Timer();

    public Day7() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args) {
        Day7 d = new Day7();
    }
    private int problem1(List<String> list) {
        timer.startTimer();
        String[] parts = new String[999];
        List<Integer> crabs =new ArrayList<>();
        for (String s: list) {
            parts = s.split("," );
        }
        for (String s: parts) {
            crabs.add(Integer.parseInt(s));
        }
        crabs = crabs.stream().sorted().collect(Collectors.toList());

        int numberOfCrabs= crabs.size();
        int counter = 0;
        numberOfCrabs = numberOfCrabs/2;
        int median = crabs.get(numberOfCrabs);
        for (Integer i: crabs) {
            if (i<median){
                counter +=median-i;
            }else{counter +=i - median;}
        }
        timer.stopTimer("Day7", "Problem1");
        return counter;
    }

    private long problem2(List<String> list) {
        timer.startTimer();
        String[] parts = new String[999];
        List<Integer> crabs =new ArrayList<>();
        for (String s: list) {
            parts = s.split("," );
        }
        for (String s: parts) {
            crabs.add(Integer.parseInt(s));
        }

        crabs = crabs.stream().sorted().collect(Collectors.toList());

        double totalSum=0;

        for (Integer i: crabs) {
            totalSum+=i-1;
        }
        double position = totalSum/crabs.size();

        long answer=0;
        for (Integer i : crabs) {
            if (i<Math.round(position)){
                long difference= Math.round(position)-i;
                answer+=(difference * (difference + 1)) / 2;

            }else{
                long difference= i-Math.round(position);
                answer+=(difference * (difference + 1)) / 2; }
        }
        timer.stopTimer("Day7", "Problem2");
        return  answer;
    }


}
