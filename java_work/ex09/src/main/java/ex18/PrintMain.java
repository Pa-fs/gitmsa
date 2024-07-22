package ex18;

public class PrintMain {

    public static void main(String[] args) {
        String mydoc = "mydocument";

        Printable prn = new SPrint();
        prn.print(mydoc);

        prn = new LPrint();
        prn.print(mydoc);
    }
}
