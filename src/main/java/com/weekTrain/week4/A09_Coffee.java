package com.weekTrain.week4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Baven
 * @date 2022/4/24 8:58
 */
public class A09_Coffee {
    public static class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int i, int j) {
            timePoint = i;
            workTime = j;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {
        @Override
        public int compare(Machine o1, Machine o2) {
            return o1.timePoint - o2.timePoint;
        }
    }

    public static int minTime1(int[] workTime, int n, int wash, int air) {
        PriorityQueue<Machine> heapTime = new PriorityQueue<>(new MachineComparator());
        for (int i = 0; i < workTime.length; i++) {
            heapTime.add(new Machine(0, workTime[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heapTime.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heapTime.add(cur);
        }
        return bestTime1(drinks, 0, wash, air, 0);
    }

    public static int bestTime1(int[] drinks, int index, int wash, int air, int machineFree) {
        if (index == drinks.length) {
            return 0;
        }
        int selfTime1 = Math.max(machineFree, drinks[index]) + wash;
        int restTime1 = bestTime1(drinks, index + 1, wash, air, selfTime1);
        int p1 = Math.max(selfTime1, restTime1);

        int selfTime2 = drinks[index] + air;
        int restTime2 = bestTime1(drinks, index + 1, wash, air, machineFree);
        int p2 = Math.max(selfTime2, restTime2);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int wash = 3;
        int air = 4;
        int n = 6;
        System.out.println(minTime1(arr, n, wash, air));
    }
}
