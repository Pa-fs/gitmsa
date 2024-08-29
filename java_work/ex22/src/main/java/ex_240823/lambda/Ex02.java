package ex_240823.lambda;

interface Printable {
    void print();
}

class Papers {
    private String con;

    public Papers(String con) {
        this.con = con;
    }

    public Printable getPrint() {
        return new Printable() {
            @Override
            public void print() {
                System.out.println(con);
            }
        };
    }
}

/*
    public Printable getPrint() {
        class Printer implements Printable{
            @Override
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }
 */

public class Ex02 {

    public static void main(String[] args) {
        Papers papers = new Papers("출력할 내용");
        Printable print = papers.getPrint();
        print.print();
    }
}
