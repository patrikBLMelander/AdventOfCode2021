import java.io.IOException;
import java.util.*;

/**
 * Created by Patrik Melander
 * Date: 2021-12-14
 * Time: 11:21
 * Project: AdventOfCode2021
 * Copyright: MIT
 *
 * NOT WORKING
 */
public class Day15NotWorking {
    List<String> list = InputReader.readStringFile("test.txt");
    Timer timer = new Timer();

    long answer1;
    long answer2;
    public static void main(String[] args) throws IOException {
        Day15NotWorking d = new Day15NotWorking();
    }

    public Day15NotWorking() {
        problem1(list);
        System.out.println("Answer: " + answer1);
        System.out.println("Answer:" + answer2);
    }

    private void problem1(List<String> list) {
        int[][] map = new int[list.size()][list.get(0).length()];
        int[][] map2 = new int[list.size() * 5][list.get(0).length() * 5];

        for (int row = 0; row < list.size(); row++) {
            String s = list.get(row);
            for (int col = 0; col < s.length(); col++) {
                int value = s.charAt(col) - 48;
                map[row][col] = value;

                for (int rowRep = 0; rowRep < 5; rowRep++) {
                    for (int colRep = 0; colRep < 5; colRep++) {
                        int newVal = (value + rowRep + colRep);
                        while (newVal > 9)
                            newVal -= 9;

                        map2[row + (rowRep * list.size())][col + (colRep * s.length())] = newVal;
                    }
                }
            }
        }

        answer1= pathFind(map);
        answer2= pathFind(map2);
    }


        public long pathFind(int[][] map)
        {
            Set<Point> visited = new HashSet<>();
            Map<Point, Long> available = new HashMap<>();
            available.put(new Point(0, 0), 0L);
            while(available.size() > 0)
            {
                long lowestVal = Long.MAX_VALUE;
                Point lowest = null;
                for(Point p : available.keySet())
                {
                    long pVal = available.get(p);
                    if(pVal < lowestVal)
                    {
                        lowest = p;
                        lowestVal = pVal;
                    }
                }

                if(lowest.row == map.length - 1 && lowest.col == map[0].length - 1)
                {
                    return lowestVal;

                }

                available.remove(lowest);
                visited.add(lowest);

                List<Point> toCheck = new ArrayList<>();
                if(lowest.col - 1 >= 0)
                    toCheck.add(new Point(lowest.row, lowest.col - 1));
                if(lowest.col + 1 < map[lowest.row].length)
                    toCheck.add(new Point(lowest.row, lowest.col + 1));
                if(lowest.row - 1 >= 0)
                    toCheck.add(new Point(lowest.row - 1, lowest.col));
                if(lowest.row + 1 < map.length)
                    toCheck.add(new Point(lowest.row + 1, lowest.col));

                for(Point newPoint : toCheck)
                {
                    if(!visited.contains(newPoint))
                    {
                        long pointVal = map[newPoint.row][newPoint.col] + lowestVal;
                        if(available.getOrDefault(newPoint, Long.MAX_VALUE) > pointVal)
                            available.put(newPoint, pointVal);
                    }
                }
            }
            return 0L;
        }

    }