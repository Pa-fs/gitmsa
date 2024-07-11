package ex05;
class A{

}
public class Arr {

    public static void main(String[] args) {
        // int 배열은 값을 넣지 않으면 0으로 초기화
        // new 키워드, 힙 메모리에 할당
        int[] a = new int[10];
        System.out.println("a.length = " + a.length);

        String a1 = new String("123");
        String a2 = new String("123");
        System.out.println(a1 == a2);
    }
}
