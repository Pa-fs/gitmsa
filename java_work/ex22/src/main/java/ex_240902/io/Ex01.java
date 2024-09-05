package ex_240902.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex01 {

    public static void main(String[] args) {

        try (OutputStream os = new FileOutputStream("copyfile");
             InputStream is = new FileInputStream("myfile")
        ) {
            byte[] buf = new byte[1024];
            while (true) {
                int data = is.read(buf);
                if(data == -1) break;
                System.out.println(data);
                os.write(buf, 0, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
