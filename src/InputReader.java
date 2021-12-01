import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-01
 * Time: 18:28
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class InputReader {
    static String folder = "inputs\\";
    public static List<Long> readLongFile(String filename) {
        List<Long> longList = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(folder + filename))) {
            String nextLine;
            while ((nextLine = input.readLine()) != null) {
                longList.add(Long.parseLong(nextLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longList;
    }


    public static List<String> readStringFile(String filename) {
        List<String> list = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(folder + filename))) {
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Integer> readIntegerFile(String filename) {
        List<Integer> integerList = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(folder + filename))) {
            String nextLine;
            while ((nextLine = input.readLine()) != null) {
                integerList.add(Integer.parseInt(nextLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }
}
