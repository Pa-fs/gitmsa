package org.example;

import org.example.aa.Student;

public class Main {


    Main() {
        Student student = new Student("홍길동", 35, 12, 39);
        System.out.println(student);

        student.getTotal();
        student.getAverage();
    }
    public static void main(String[] args) {

        new Main();
    }
}
