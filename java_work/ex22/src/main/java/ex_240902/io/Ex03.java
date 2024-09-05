package ex_240902.io;

import java.io.FileReader;

public class Ex03 {

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("myfile");

//        // 한 문자 읽음
//        int ch = fr.read();
//        System.out.println((char) ch);

        while (true) {
            int ch = fr.read();
            System.out.println(ch);
            System.out.println((char) ch);

            if (ch == -1) {
                break;
            }
        }
    }
}
