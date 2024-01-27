package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        Queue<Integer> starts = new LinkedList<>();
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0)
                starts.add(i);
        }

        if (starts.isEmpty()) return -1;

        while (!starts.isEmpty()) {
            int start = starts.poll();
            int index = start;
            int tank = 0;
            while (tank + gas[index] - cost[index] >= 0) {
                tank += gas[index];
                tank -= cost[index];
                index++;
                if (index == gas.length)
                    index = 0;
                if (index == start)
                    return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("ANS: " + canCompleteCircuit(
                new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}
        ));
    }
}