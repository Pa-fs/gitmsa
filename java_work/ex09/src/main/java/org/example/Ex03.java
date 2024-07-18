package org.example;

import org.example.aa.BizMan;
import org.example.aa.Man;

public class Ex03 {

    public static void main(String[] args) {
        Man man = new BizMan("홍길동", "그린컴퓨터", "선생님");

        ((BizMan) man).showInfo();

    }
}
