import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Patrik Melander
 * Date: 2021-12-16
 * Time: 08:44
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day16 {
    List<String> list = InputReader.readStringFile("day16.txt");
    Timer timer = new Timer();
    public String binary;
    public int positionInBinary;
    public long answer;


    public static void main(String[] args) throws IOException {
        Day16 d = new Day16();
    }

    public Day16() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private long problem1(List<String> list) {
        timer.startTimer();

        StringBuilder sb = new StringBuilder();
        for(char c : list.get(0).toCharArray())
        {
            String binary = new BigInteger(String.valueOf(c), 16).toString(2);
            sb.append("0".repeat(4 - binary.length())).append(binary);
        }
        binary = sb.toString();
        positionInBinary = 0;
        answer = 0;

        parsePacket();

        timer.stopTimer("Day16", "Problem1");
        return answer;
    }

    private long problem2(List<String> list) {
        timer.startTimer();
        String hex = list.get(0);
        StringBuilder builder = new StringBuilder();
        for(char c : hex.toCharArray())
        {
            String binary = new BigInteger(String.valueOf(c), 16).toString(2);
            builder.append("0".repeat(4 - binary.length())).append(binary);
        }
        binary = builder.toString();
        positionInBinary = 0;
        answer = 0;
        long value = parsePacket();

        timer.stopTimer("Day16", "Problem2");
        return value;
    }

    public long parsePacket() {
        //Version length are always 3 in the beginning
        int version = readPartInt(3);
        answer += version;

        //After the version comes the type ID and its always length of 3
        return switch (readPartInt(3)) {
            case 0 -> parseSum();
            case 1 -> parseProduct();
            case 2 -> parseMin();
            case 3 -> parseMax();
            case 4 -> parseLiteral();
            case 5 -> parseGreaterThan();
            case 6 -> parseLessThan();
            case 7 -> parseEqualTo();
            default -> 0;
        };
    }
    public long parseSum() {
        long toReturn = 0;

        for(long l : parseOP())
            toReturn += l;

        return toReturn;
    }

    public long parseProduct() {
        long toReturn = 1;

        for(long l : parseOP())
            toReturn *= l;

        return toReturn;
    }

    public long parseMin() {
        long min = Long.MAX_VALUE;

        for(long l : parseOP())
            min = Math.min(l, min);

        return min;
    }

    public long parseMax() {
        long max = Long.MIN_VALUE;

        for(long l : parseOP())
            max = Math.max(l, max);

        return max;
    }

    public long parseGreaterThan() {
        List<Long> nums = parseOP();
        return nums.get(0) > nums.get(1) ? 1 : 0;
    }

    public long parseLessThan() {
        List<Long> nums = parseOP();
        return nums.get(0) < nums.get(1) ? 1 : 0;
    }

    public long parseEqualTo() {
        List<Long> nums = parseOP();
        return Objects.equals(nums.get(0), nums.get(1)) ? 1 : 0;
    }

    public List<Long> parseOP() {
        List<Long> nums = new ArrayList<>();
        if(readPartInt(1) == 0) {
            int length = readPartInt(15);
            int startCursor = positionInBinary;
            while(positionInBinary < startCursor + length)
                nums.add(parsePacket());
        }
        else {
            int NumPackets = readPartInt(11);
            for(int p = 0; p < NumPackets; p++)
                nums.add(parsePacket());
        }

        return nums;
    }

    public long parseLiteral() {
        int start = readPartInt(1);
        StringBuilder builder = new StringBuilder();
        while(start == 1) {
            builder.append(readPart(4));
            start = readPartInt(1);
        }
        builder.append(readPart(4));
        return Long.parseLong(builder.toString(), 2);
    }

    /*
        Reads from the position in the string we are and the length we provide

        Moves the position forward in binary string
    */
    public String readPart(int length) {
        String s = binary.substring(positionInBinary, positionInBinary + length);
        positionInBinary += length;
        return s;
    }

    /*
        Read the binary String and makes it integer
     */
    public int readPartInt(int length) {
        return Integer.parseInt(readPart(length), 2);
    }

}
