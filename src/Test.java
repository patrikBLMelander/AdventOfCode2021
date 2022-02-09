import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrik Melander
 * Date: 2021-12-18
 * Time: 17:26
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Test {
    private static boolean explode(List<Node> list) {
        for (var i = 0; i < list.size(); i++) {
            if (list.get(i).depth != 4) continue;
            var left = list.get(i);
            var newDepth = left.depth - 1;
            if (i != 0) {
                list.get(i - 1).value += left.value;
            }
            var right = list.get(i + 1);
            if (i < list.size() - 2) {
                list.get(i + 2).value += right.value;
            }
            list.remove(i + 1);
            list.remove(i);
            list.add(i, new Node(newDepth));
            return true;
        }
        return false;
    }

    private static boolean split(List<Node> list) {
        for (var i = 0; i < list.size(); i++) {
            if (list.get(i).value > 9) {
                var nodeToSplit = list.get(i);
                var splitDepth = nodeToSplit.depth + 1;
                var splitValue = (float)nodeToSplit.value;
                list.remove(i);
                list.add(i, new Node(splitDepth, (int)Math.floor(splitValue / 2)));
                list.add(i + 1, new Node(splitDepth, (int)Math.ceil(splitValue / 2)));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var lines = getInput();

        var largestMagnitude = Integer.MIN_VALUE;

        for (var lineIdx1 = 0; lineIdx1 < lines.length; lineIdx1++) {
            for (var lineIdx2 = 0; lineIdx2 < lines.length; lineIdx2++) {
                if (lineIdx1 == lineIdx2) continue;

                List<Node> sumResult = performSum(parseLine(lines[lineIdx1]), parseLine(lines[lineIdx2]));

                var reduced = false;
                do {
                    reduced = explode(sumResult);
                    if (reduced) continue;
                    reduced = split(sumResult);
                } while (reduced);

                var magnitude = magnitude(sumResult);

                if (magnitude > largestMagnitude) largestMagnitude = magnitude;
            }
        }

        System.out.println(largestMagnitude);
    }

    private static List<Node> performSum(List<Node> operandA, List<Node> operandB) {
        if (operandA.isEmpty()) return operandB;
        operandA.addAll(operandB);
        operandA = operandA.stream().peek(e -> e.depth++).collect(Collectors.toList());
        return operandA;
    }

    private static int magnitude(List<Node> list) {
        for (var depth = 3; depth >= 0; depth--) {
            var reduced = false;
            do {
                reduced = false;
                for (var j = 0; j < list.size() - 1; j++) {
                    var left = list.get(j);
                    var right = list.get(j + 1);
                    if (left.depth != depth) continue;
                    list.remove(j + 1);
                    list.remove(j);
                    list.add(j, new Node(depth - 1, 3 * left.value + 2 * right.value));
                    reduced = true;
                    break;
                }
            } while (reduced);
        }
        return list.get(0).value;
    }

    private static List<Node> parseLine(String line) {
        var list = new ArrayList<Node>();
        var depth = -1;
        for (var cc : line.toCharArray()) {
            switch (cc) {
                case '[':
                    depth++;
                    break;
                case ']':
                    depth--;
                    break;
                case ',':
                    break;
                default:
                    var value = Integer.parseInt(String.valueOf(cc));
                    var node = new Node();
                    node.depth = depth;
                    node.value = value;
                    list.add(node);
                    break;
            }
        }
        return list;
    }

    static class Node {
        int value = 0;
        int depth;

        public Node() {
        }
        public Node(int depth) {
            this.depth = depth;
        }
        public Node(int depth, int value) {
            this.depth = depth;
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private static String[] getInput() {
        return ("...").split("\n");
    }
}
