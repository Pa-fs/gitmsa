package ex_240813;

class MyBox<T extends Number> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        MyBox<Integer> myBox1 = new MyBox<>();

        /**
         * extends Number 이기 때문에 아래 자식들만 허용됨
         * 그래서 자식들 공통 메서드를 사용 가능
         * ex) ob.intValue()
         * 아래 String은 불가
         */
//        MyBox<String> myBox2 = new MyBox<>();

    }
}
