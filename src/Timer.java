/**
 * Created by Patrik Melander
 * Date: 2021-12-14
 * Time: 12:31
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Timer {
    long startTime;


    public void startTimer(){
        long startTime = System.nanoTime();
    }

    public void stopTimer(String day, String problem){
        System.out.printf(day + " "+ problem +": Execution time: %f milliseconds%n", ((double) System.nanoTime() - startTime) / 1000000);
    }




}
