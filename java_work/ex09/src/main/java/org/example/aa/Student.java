package org.example.aa;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private int kor;
    private int eng;
    private int math;


    public void getTotal() {
        System.out.println("총합= " + (kor+eng+math));
    }

    public void getAverage() {

        int v = (int)(Math.round((kor + eng + math) / (double) 3 * 10));
        System.out.println(v);
        double res = (double)v / 10;
        System.out.println("평균= " + res);
    }
}
