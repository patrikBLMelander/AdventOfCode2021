import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-12-22
 * Time: 08:29
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Day22 {
    List<String> list = InputReader.readStringFile("day22.txt");
    Timer timer = new Timer();


    public static void main(String[] args) throws IOException {
        Day22 d = new Day22();
    }

    public Day22() {
        System.out.println("Answer: " + problem1(list));
        System.out.println("Answer:" + problem2(list));
    }

    private int problem1(List<String> list) {
        timer.startTimer();
        int counter=0;
        int[][][]cubes = new int[101][101][101];
        List<String> onOff = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] parts = list.get(i).replace(",", " ").split(" ");
            onOff.add(parts[0]);
            int onOrOff=0;
            if(onOff.get(i).equals("on")){
                onOrOff=1;
                int startX =50+Integer.parseInt(parts[1].replace("x=","" ).split("\\.\\.")[0]);
                int endX =50+Integer.parseInt(parts[1].split("\\.\\.")[1]);
                int startY =50+Integer.parseInt(parts[2].replace("y=","" ).split("\\.\\.")[0]);
                int endY =50+Integer.parseInt(parts[2].split("\\.\\.")[1]);
                int startZ =50+Integer.parseInt(parts[3].replace("z=","" ).split("\\.\\.")[0]);
                int endZ =50+Integer.parseInt(parts[3].split("\\.\\.")[1]);

                for (int x = startX; x <=endX ; x++) {
                    for (int y = startY; y <=endY ; y++) {
                        for (int z = startZ; z <=endZ; z++) {
                            cubes[x][y][z]=onOrOff;
                        }
                    }
                }

            }else{
                int startX =50+Integer.parseInt(parts[1].replace("x=","" ).split("\\.\\.")[0]);
                int endX =50+Integer.parseInt(parts[1].split("\\.\\.")[1]);
                int startY =50+Integer.parseInt(parts[2].replace("y=","" ).split("\\.\\.")[0]);
                int endY =50+ Integer.parseInt(parts[2].split("\\.\\.")[1]);
                int startZ =50+Integer.parseInt(parts[3].replace("z=","" ).split("\\.\\.")[0]);
                int endZ =50+ Integer.parseInt(parts[3].split("\\.\\.")[1]);

                for (int x = startX; x <=endX ; x++) {
                    for (int y = startY; y <=endY ; y++) {
                        for (int z = startZ; z <=endZ; z++) {
                            cubes[x][y][z]=onOrOff;
                        }
                    }
                }
            }

        }
        for (int x = 0; x <=100 ; x++) {
            for (int y = 0; y <=100 ; y++) {
                for (int z = 0; z <=100; z++) {
                    System.out.println("x"+ x +",y"+ y +",z"+ z + " onOff?" + cubes[x][y][z]);
                    if (cubes[x][y][z]==1){
                        counter++;
                    }
                }
            }
        }


        timer.stopTimer("Day22", "Problem1");
        return counter;
    }

    private String problem2(List<String> list) {
        timer.startTimer();

        timer.stopTimer("Day22", "Problem2");

        return null;
    }
}

