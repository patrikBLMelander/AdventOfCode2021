
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-02
 * Time: 08:48
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day3 {
    List<String> list = InputReader.readStringFile("day3.txt");
    Timer timer = new Timer();

    public Day3() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args) {
        Day3 d = new Day3();
    }



    public int problem1(List<String> list) {
        timer.startTimer();
        int counterA=0;
        int counterB=0;
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();


        for (int i = 0; i < 12; i++) {
            for (String s : list) {
                char[] charArray = s.toCharArray();
                if (charArray[i] == '1') {
                    counterA += 1;
                } else counterB += 1;

            }
            if(counterA<counterB){
                gammaRate.append("1");
                epsilonRate.append("0");
            }else{
                gammaRate.append("0");
                epsilonRate.append("1");
            }
            counterA=0;
            counterB=0;
        }
        int gamma = Integer.parseInt(gammaRate.toString(), 2);
        int epsilon = Integer.parseInt(epsilonRate.toString(), 2);


        timer.stopTimer("Day3", "Problem1");
        return gamma* epsilon;
    }

    public int problem2(List<String> list) {
        timer.startTimer();
        int OGR = Integer.parseInt(oxygenGeneratorRating(list), 2);
        int CO2 = Integer.parseInt(CO2ScrubberRating(list), 2);

        timer.stopTimer("Day3", "Problem2");
        return OGR*CO2;
    }

    public String oxygenGeneratorRating(List<String> list){
        int counter1a=0;
        int counter=0;

        List <String> newList = new ArrayList<>();
        while (list.size()>1){

            for (String s : list) {
                char[] charArray = s.toCharArray();
                if (charArray[counter] == '1') {
                    counter1a += 1;
                }
            }
            if(counter1a*2>=list.size()) {
                for (String s1 : list) {
                    char[] charArray1 = s1.toCharArray();
                    if (charArray1[counter] == '1') {
                        newList.add(s1);
                    }

                }
            }else{
                for (String s1 : list) {
                    char[] charArray1 = s1.toCharArray();
                    if (charArray1[counter] == '0') {
                        newList.add(s1);
                    }

                }
            }
            counter1a=0;
            counter++;
            list = newList;
            newList= new ArrayList<>();

        }
        return list.get(0);
    }

    public static String CO2ScrubberRating(List<String> list){
        int counter1a=0;
        int counter=0;

        List <String> newList = new ArrayList<>();
        while (list.size()>1){

            for (String s : list) {
                char[] charArray = s.toCharArray();
                if (charArray[counter] == '1') {
                    counter1a += 1;
                }
            }
            if(counter1a*2<list.size()) {
                for (String s1 : list) {
                    char[] charArray1 = s1.toCharArray();
                    if (charArray1[counter] == '1') {
                        newList.add(s1);
                    }

                }
            }else{
                for (String s1 : list) {
                    char[] charArray1 = s1.toCharArray();
                    if (charArray1[counter] == '0') {
                        newList.add(s1);
                    }

                }
            }
            counter1a=0;
            counter++;
            list = newList;
            newList= new ArrayList<>();

        }

        return list.get(0);
    }

}
