package ex06;

public class Main {

    public static void main(String[] args) {

        // 인스턴스화 메모리적재 된다
        Box abox = new Box("사과");
        Box bbox = new Box();
        Box cbox = new Box("바나나", 10);

        System.out.println(abox);
        System.out.println(bbox);
        System.out.println(cbox);
    }
}
