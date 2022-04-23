package com.weekTrain.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baven
 * @date 2022/4/1 20:54
 */
public class B17_MaxHappy {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static class Info {
        public int no;
        public int yes;

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public static Info process(Employee e) {
        if (e == null) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = e.happy;
        for (Employee next : e.nexts) {
            Info nextInfo = process(next);
            no += Math.max(nextInfo.no, nextInfo.yes);
            yes += nextInfo.no;
        }
        return new Info(no, yes);
    }

    public static void main(String[] args) {

    }
}
