package org.example;

class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + gas[i] - cost[i];
        }
        if (sum < 0) return -1;

        int surplus = 0;
        int startStation = 0;
        for (int i = 0; i < n; i++) {
            surplus = surplus + gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                startStation = i + 1;
            }
        }
        return startStation;
    }
}