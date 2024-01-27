package org.example;

class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        System.out.println("ANS: " + canCompleteCircuit(
                new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}
        ));
    }
}