package ex_240813;

import java.util.*;

public class Ex01 {

    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        Box<String> box3 = new Box<>();

        Box<Scanner> box4 = new Box<>();
        Box<StringTokenizer> box5 = new Box<>();
        Box<Random> box6 = new Box<>();

        box1.setObj(new Apple());
        box2.setObj(new Orange());

        box3.setObj("apple");
//        box3.setObj(new Apple());

        Apple apple = box1.getObj();
        Orange orange = box2.getObj();

    }
}
