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

    public Day7() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day7 d = new Day7();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    private long problem2(List<String> list) {
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
        return  answer;
    }

    private int problem1(List<String> list) {
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

        return counter;
    }
}
