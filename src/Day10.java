import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-09
 * Time: 17:40
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day10 {
    List<String> list = InputReader.readStringFile("day10.txt");

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day10 d = new Day10();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public Day10() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    private long problem1(List<String> list) {
        long score=0;


        for (String s : list) {
          List<Character> chars = new ArrayList<>();
          boolean exit = false;
            for (char c : s.toCharArray()) {
                switch (c){
                    case '(':
                    case '[':
                    case'{':
                    case'<':
                        chars.add(c);
                        break;
                    case')':
                        if (chars.remove(chars.size()-1)!='('){
                            score +=3;
                            exit=true;
                        }
                        break;
                    case']':
                        if (chars.remove(chars.size()-1)!='['){
                            score +=57;
                            exit=true;
                        }
                        break;
                    case'}':
                        if (chars.remove(chars.size()-1)!='{'){
                            score +=1197;
                            exit=true;
                        }
                        break;
                    case'>':
                        if (chars.remove(chars.size()-1)!='<'){
                            score +=25137;
                            exit=true;
                        }
                        break;
                }
                if (exit){
                    break;
                }
            }

        }



        return score;
    }

    private long problem2(List<String> list) {
        for(int i = list.size() - 1; i >= 0; i--){
            List<Character> stack = new ArrayList<>();
            for(char c : list.get(i).toCharArray()) {
                boolean exit = false;
                switch(c) {
                    case '(':
                    case '[':
                    case '{':
                    case '<':
                        stack.add(c);
                        break;
                    case ')':
                        if(stack.remove(stack.size() - 1) != '(') {
                            exit = true;
                        }
                        break;
                    case ']':
                        if(stack.remove(stack.size() - 1) != '[') {
                            exit = true;
                        }
                        break;
                    case '}':
                        if(stack.remove(stack.size() - 1) != '{') {
                            exit = true;
                        }
                        break;
                    case '>':
                        if(stack.remove(stack.size() - 1) != '<')
                        {
                            exit = true;
                        }
                        break;
                }

                if(exit)
                {
                    list.remove(i);
                    break;
                }
            }
        }

        List<Long> scores = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--) {
            List<Character> queue = new ArrayList<>();
            for(char c : list.get(i).toCharArray()) {
                switch (c) {
                    case '(', '[', '{', '<' -> queue.add(c);
                    case ')', ']', '}', '>' -> queue.remove(queue.size() - 1);
                }
            }
            long score = 0;
            while(queue.size() > 0)
            {
                char c = queue.remove(queue.size() - 1);
                score *= 5;
                switch (c) {
                    case '(' -> score += 1;
                    case '[' -> score += 2;
                    case '{' -> score += 3;
                    case '<' -> score += 4;
                }
            }
            scores.add(score);
        }
        scores.sort(Long::compareTo);
        return scores.get((scores.size()) / 2);
    }
}

