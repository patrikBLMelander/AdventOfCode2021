import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12
{
    public Map<String, List<String>> paths;

    List<String> list = InputReader.readStringFile("day12.txt");

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        Day12 d = new Day12();
        System.out.printf("Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }

    public Day12() throws IOException {
        System.out.println("Answer Problem 1: " + problem1(list));
        //System.out.println("Answer Problem 2: " + problem2(list));
    }



    private int problem1(List<String> list) {
        paths = new HashMap<>();
        for(String s : list) {
            String[] pathParts = s.trim().split("-");
            paths.computeIfAbsent(pathParts[0], k -> new ArrayList<>()).add(pathParts[1]);
            paths.computeIfAbsent(pathParts[1], k -> new ArrayList<>()).add(pathParts[0]);
        }

        return (navigate("start", new ArrayList<>(), false).size());
    }

    private int problem2(List<String> list) {

        return(0);
    }




    public List<List<String>> navigate(String pos, List<String> visited, boolean allowTwice)
    {
        if(pos.equalsIgnoreCase("end"))
        {
            List<String> one = new ArrayList<>();
            one.add("end");
            List<List<String>> two = new ArrayList<>();
            two.add(one);
            return two;
        }

        List<List<String>> toReturn = new ArrayList<>();

        if(allowTwice && !pos.equals("start"))
        {
            for(String dest : paths.get(pos))
            {
                if(dest.charAt(0) >= 'a' && dest.charAt(0) <= 'z' && visited.contains(dest))
                    continue;
                List<List<String>> toAdd = navigate(dest, new ArrayList<>(visited), false);
                for(int i = toAdd.size() - 1; i >= 0; i--)
                {
                    boolean remove = true;
                    for(String s : toAdd.get(i))
                    {
                        if(s.equals(pos))
                        {
                            remove = false;
                            break;
                        }
                    }

                    if(remove)
                        toAdd.remove(i);
                }
                toReturn.addAll(toAdd);
            }
        }

        visited.add(pos);
        for(String dest : paths.get(pos))
        {
            if(dest.charAt(0) >= 'a' && dest.charAt(0) <= 'z' && visited.contains(dest))
                continue;
            toReturn.addAll(navigate(dest, new ArrayList<>(visited), allowTwice));
        }

        for(List<String> sp : toReturn)
            sp.add(pos);

        return toReturn;
    }
}