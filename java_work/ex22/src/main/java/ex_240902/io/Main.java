package ex_240902.io;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        try(OutputStream os = new FileOutputStream("data.dat")){
            os.write(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("data.dat")) {
            int dat = is.read();
            System.out.println(dat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
