import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-08
 * Time: 07:07
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day8 {
    List<String> list = InputReader.readStringFile("test.txt");
    Timer timer = new Timer();

    public Day8() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    public static void main(String[] args) {
        Day8 d = new Day8();
    }
    private int problem1(List<String> list) {
        timer.startTimer();
        int counter= 0;
        List<String> secondHalf=new ArrayList<>();
        for (String s : list) {
           int temp=  s.indexOf('|');
            secondHalf.add(s.substring(temp));
        }
        for (String s : secondHalf) {
            String[] parts = s.split(" ");

            for (String part : parts) {
                if (part.length() == 2 || part.length() == 3 || part.length() == 4 || part.length() == 7) {
                    counter++;
                }
            }
        }
        timer.stopTimer("Day8", "Problem1");
        return counter;
    }
    private int problem2(List<String> list) {
        timer.startTimer();

            int sum = 0;
            for(String s : list)
            {
                String[] parts = s.split("\\|");
                String[] firstHalf = parts[0].strip().split(" ");
                String[] secondHalf = parts[1].strip().split(" ");
                String[] digits = new String[10];

                //Need to check this first to be able to compare the others later
                for(String check1478 : firstHalf)
                {
                    switch (check1478.length()) {
                        case 2 -> digits[1] = check1478;
                        case 3 -> digits[7] = check1478;
                        case 4 -> digits[4] = check1478;
                        case 7 -> digits[8] = check1478;
                    }
                }

                //Checking all with 6 length first because I need digits[6] to check 5
                for(String check069 : firstHalf)
                {
                    if(check069.length() == 6)
                    {
                        if(isNine(digits, check069))
                            digits[9] = check069;
                        else if(isZero(digits, check069))
                            digits[0] = check069;
                        else
                            digits[6] = check069;
                    }
                }

                for(String check235 : firstHalf)
                {
                    if(check235.length() == 5)
                    {
                        if(isThree(digits, check235))
                            digits[3] = check235;
                        else if(isFive(digits, check235))
                            digits[5] = check235;
                        else
                            digits[2] = check235;
                    }
                }

                for(int i = 0; i < 10; i++)
                    digits[i] = order(digits[i]);

                int number = 0;
                for(String toFind : secondHalf)
                {
                    String sorted = order(toFind);
                    for(int i = 0; i < 10; i++)
                        if(digits[i].equals(sorted)){
                            //move numbers to the left
                            number = (number * 10) + i;
                        }
                }
                sum += number;

            }
            timer.stopTimer("Day8", "Problem2");
            return sum;
        }

        public String order(String toOrder)
        {
            char[] toSort = toOrder.toCharArray();
            Arrays.sort(toSort);
            return new String(toSort);
        }

        public boolean isNine(String[] digits, String sPart)
        {
            boolean nine = true;
            for(char c : digits[4].toCharArray())
            {
                if(!sPart.contains(String.valueOf(c)))
                {
                    nine = false;
                    break;
                }
            }
            return nine;
        }

        public boolean isZero(String[] digits, String sPart)
        {
            boolean zero = true;
            for(char c : digits[1].toCharArray())
            {
                if(!sPart.contains(String.valueOf(c)))
                {
                    zero = false;
                    break;
                }
            }
            return zero;
        }

        public boolean isThree(String[] digits, String sPart)
        {
            boolean three = true;
            for(char c : digits[1].toCharArray())
            {
                if(!sPart.contains(String.valueOf(c)))
                {
                    three = false;
                    break;
                }
            }
            return three;
        }

        public boolean isFive(String[] digits, String sPart)
        {
            int missing = 0;
            for(char c : digits[6].toCharArray())
                if(!sPart.contains(String.valueOf(c)))
                    missing++;
            return missing == 1;
        }

}
