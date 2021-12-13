import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Patrik Melander
 * Date: 2021-12-08
 * Time: 11:44
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day9 {

    List<String> list = InputReader.readStringFile("day9.txt");

    public Day9() {
        System.out.println("Answer Problem 1: " + problem1(list));
        System.out.println("Answer Problem 2: " + problem2(list));
    }

    private int problem1(List<String> list) {
        int verticalCounter = 0;
        int horizontalCounter = 0;
        int sum = 0;

        Map<String, Character> smokeMap = new HashMap<>();

        for (String s : list) {
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                String key = "h"+horizontalCounter+"v"+verticalCounter;
                smokeMap.put(key, c);
                horizontalCounter++;
            }
            verticalCounter++;
            horizontalCounter=0;
        }

        for (int i = 0; i < list.get(0).length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String key = "h" + i + "v" + j;
                String keyRight = "h" + (i+1) + "v" + (j);
                String keyLeft = "h" + (i-1) + "v" + (j);
                String keyUp = "h" + i + "v" + (j-1);
                String keyDown = "h" + i + "v" + (j+1);
                int maxHorizontal=list.get(0).length()-1;
                int maxVertical=list.size()-1;


                //check top left corner
                if(key.equals("h0v0")){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //check top right corner
                else if(key.equals("h"+maxHorizontal+"v0")){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                    Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //check bottom Left corner
                else if(key.equals("h0"+"v"+maxVertical)){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                        Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //check bottom right corner
                else if(key.equals("h"+maxHorizontal+"v"+maxVertical)){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //check top row
                else if(key.contains("v0")){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }

                //check bottom row
                else if(key.contains("v"+maxVertical)){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //Check first row
                else if(key.contains("h0")){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;
                    }
                }
                //check last row
                else if(key.contains("h"+maxHorizontal)){
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;

                    }
                }
                //check rest
                else{
                    if(Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyDown).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyLeft).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyRight).toString())&&
                            Integer.parseInt(smokeMap.get(key).toString())<Integer.parseInt(smokeMap.get(keyUp).toString())){
                        sum+=Integer.parseInt(smokeMap.get(key).toString())+1;

                    }
                }

            }
        }


        return sum;
    }

    private int problem2(List<String> list) {

        List<List<Integer>> values = new ArrayList<>();

        for (String s : list) {
            var line = Arrays.stream(s.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            values.add(line);
        }


        List<Point> lowPoints = new ArrayList<>();
        for (int verticalCounter = 0; verticalCounter < values.size(); verticalCounter++) {
            List<Integer> row = values.get(verticalCounter);
            for (int horizontalCounter = row.size() - 1; horizontalCounter >= 0; horizontalCounter--) {
                Integer currentSmokeValue = row.get(horizontalCounter);
                if (horizontalCounter != 0 && row.get(horizontalCounter - 1) < currentSmokeValue) continue;
                if (horizontalCounter != row.size() - 1 && row.get(horizontalCounter + 1) < currentSmokeValue) continue;
                if (verticalCounter != 0 && values.get(verticalCounter - 1).get(horizontalCounter) < currentSmokeValue) continue;
                if (verticalCounter != values.size() - 1 && values.get(verticalCounter + 1).get(horizontalCounter) < currentSmokeValue) continue;
                if (currentSmokeValue != 9) {
                    lowPoints.add(new Point(verticalCounter, horizontalCounter));
                }
            }
        }

        List<List<Point>> basins = new ArrayList<>();
        for (Point lowPoint : lowPoints) {
            List<Point> basin = new ArrayList<>();

            findBasin(values, lowPoint, basin);

            basins.add(basin);
        }
        basins.sort(Comparator.comparingInt(List::size));
        Collections.reverse(basins);

        int result = 1;
        for (int i = 0; i < 3; i++) {
            result *= basins.get(i).size();
        }
        return result;
    }

    private static void findBasin(List<List<Integer>> values, Point coords, List<Point> basin) {
        int x = coords.row;
        int y = coords.col;
        if (values.get(x).get(y) == 9 || basin.contains(coords)) return;
        basin.add(coords);
        if (x != values.size() - 1) findBasin(values, new Point(x + 1, y), basin);
        if (x != 0) findBasin(values, new Point(x - 1, y), basin);
        if (y != values.get(0).size() - 1) findBasin(values, new Point(x, y + 1), basin);
        if (y != 0) findBasin(values, new Point(x, y - 1), basin);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Day9 d = new Day9();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }


}
