package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of `StudentGrade` objects containing each student's name and grades in various subjects,
//        your objective is to determine the average grade for each subject across all students and
//        identify the subject with the highest average grade. How would you approach this task?
public class Main {

    private static int price[] = { 20,10,20,30,40,50,80,10,90 };
    public static void main(String[] args) {

        MaxProfit maxProfit = new MaxProfit();
        maxProfit.findMaxProfitDays(price);

        List<StudentGrade> studentGrades = new ArrayList<>();

        Map<String, Integer> val = new HashMap<>();
        val.put("Math", 90);
        val.put("Physics", 85);
        val.put("History", 78);

        StudentGrade sg1 = new StudentGrade("name1",val);

        Map<String, Integer> val2 = new HashMap<>();
        val2.put("Math", 92);
        val2.put("Physics", 88);
        val2.put("History", 75);

        StudentGrade sg2 = new StudentGrade("name2",val2);

        Map<String, Integer> val3 = new HashMap<>();
        val3.put("Math", 85);
        val3.put("Physics", 95);
        val3.put("History", 80);

        StudentGrade sg3 = new StudentGrade("name3",val3);

//        Map<String, Integer> map = studentGrades.stream().map(sg -> sg.getGrades())
//                .collect(Collectors.toMap(value -> value,
//                        value -> 0,
//                        Integer::sum));
    }
}