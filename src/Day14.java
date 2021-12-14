
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrik Melander
 * Date: 2021-12-13
 * Time: 22:19
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day14 {
    List<String> list = InputReader.readStringFile("day14.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day14 d = new Day14();

    }

    public Day14() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer: " + problem2(list));
    }

    private long problem1(List<String> list) {
        timer.startTimer();
        String start = list.get(0);
        Map<String, String> rules = new HashMap<>();
        for (int i = 2; i < list.size(); i++) {
            String[]keyAndValue = list.get(i).split("->");
            String key = keyAndValue[0].trim();
            String value = keyAndValue[1].trim();
            rules.put(key, value);
        }
        StringBuilder newString = new StringBuilder();
        int counter =0;
        while(counter<10){
            newString.append(start.charAt(0));
            for (int i = 0; i < start.length(); i++) {
                if (i+2>start.length()){
                    break;
                }else{
                    newString.append(rules.get(start.substring(i,i+2))).append(start.charAt(i+1));
                }
            }
            start=newString.toString();
            newString.delete(0,newString.length());
            counter++;
        }
    Map<Character, Long> counterMap = new HashMap<>();
        for (char c : start.toCharArray()) {
            if (counterMap.get(c)==null){
                counterMap.put(c, 1L);
            }else{
                Long count = counterMap.get(c);
                counterMap.put(c, count+1);
            }


        }
        Character maxValue = counterMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        Character minValue = counterMap.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        timer.stopTimer("Day14", "Problem1");
        return counterMap.get(maxValue)-counterMap.get(minValue);
    }

    private Long problem2(List<String> list) {
        timer.startTimer();
        String start = list.get(0);
        Map<String, String> rules = new HashMap<>();
        for (int i = 2; i < list.size(); i++) {
            String[]keyAndValue = list.get(i).split("->");
            String key = keyAndValue[0].trim();
            String value = keyAndValue[1].trim();
            rules.put(key, value);
        }


        Map<String, Long> counterMap = new HashMap<>();
        for (int i = 0; i < start.length(); i++) {
            if (i+2>start.length()){
                break;
            }else{
                counterMap.computeIfPresent(start.substring(i, i + 2), (key, val)-> val+1);
                counterMap.putIfAbsent(start.substring(i, i + 2), 1L);

            }
        }


        int counter =0;
        while(counter<40){
            Map<String, Long> newCounterMap = new HashMap<>();
            for(String pair : counterMap.keySet())
            {
                long pairCount = counterMap.get(pair);
                String insert = rules.get(pair);
                String newPair1 = pair.charAt(0) + insert;
                String newPair2 = insert + pair.charAt(1);
                newCounterMap.put(newPair1, newCounterMap.getOrDefault(newPair1, 0L) + pairCount);
                newCounterMap.put(newPair2, newCounterMap.getOrDefault(newPair2, 0L) + pairCount);
            }
            counterMap = newCounterMap;
            counter++;
        }

        Map<Character, Long> charCounterMap = new HashMap<>();
        for(String s : counterMap.keySet()) {
            long sCount = counterMap.get(s);
            char firstLetter = s.charAt(0);
            charCounterMap.put(firstLetter, charCounterMap.getOrDefault(firstLetter, 0L) + sCount);
            char lastLetter = s.charAt(1);
            charCounterMap.put(lastLetter, charCounterMap.getOrDefault(lastLetter, 0L) + sCount);
        }

        Character maxValue = charCounterMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        Character minValue = charCounterMap.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        timer.stopTimer("Day14", "Problem2");
        return (charCounterMap.get(maxValue)-charCounterMap.get(minValue))/2;
    }
}
