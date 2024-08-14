package ex_240814;

public class Main {

    public static void main(String[] args) {
//        Box<String> steelBox = new SteelBox<>();
//        steelBox.setT("test");
//
//        System.out.println(steelBox.getT());
        BoxFactory.<Integer>peekBox(new Box<>(10));
        BoxFactory.peekBox2(new Box<>(10));
        // 이거는 안 됨
//        BoxFactory.peekBox4(new Box<>(new Object()));

        BoxFactory.peekBox5(new Box<Object>(new Object()));
        BoxFactory.peekBox5(new Box<AA>(new AA()));
        BoxFactory.peekBox5(new Box<BB>(new BB()));
        // <> 타입지정안하면 CC가 가능해짐 CC가 애매함
//        BoxFactory.peekBox5(new Box<CC>(new CC()));


        BB myBoxBB = BoxFactory.getMyBox(new Box<>(new BB()));
        AA myBoxAA = BoxFactory.getMyBox(new Box<>(new AA()));


    }
}
