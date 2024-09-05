package ex_240903;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {

    public static void main(String[] args) throws IOException {

        // 파일 생성 안됨...
        Path path = Paths.get("cc");
//        Files.createFile(path);

        // 10 유니코드로 변환하면 줄바꿈
        // 65 유니코드로 변환하면 A

        // NIO java 기반
        try (OutputStream outputStream = new DataOutputStream(Files.newOutputStream(path))) {
            outputStream.write('A');
//            outputStream.write(65);
//            outputStream.write(10);
//            outputStream.write(65);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // IO Java 기반...
//        try (BufferedOutputStream OutputStream = new BufferedOutputStream(new FileOutputStream("aa"))) {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
