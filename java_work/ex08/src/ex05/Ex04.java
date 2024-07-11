package ex05;

/*
    int 형 배열은 0으로 초기화됩니다
    String(객체) 배열은 null로 초기화 됩니다
 */
class Box {
    String conts;

    public Box(String conts) {
        this.conts = conts;
    }

    @Override
    public String toString() {
        return "Box{" +
                "conts='" + conts + '\'' +
                '}';
    }
}

public class Ex04 {

    public static void main(String[] args) {
        Box[] boxes = new Box[5];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box((i+1) + " box");
            System.out.println(boxes[i].toString());
        }
    }
}
