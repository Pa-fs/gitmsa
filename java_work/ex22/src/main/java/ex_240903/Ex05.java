package ex_240903;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex05 {

    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("d:/a/lines.file");

        List<String> list = Arrays.asList("test", "글입니다.");

        Files.write(fp, list);

        List<String> readList = Files.readAllLines(fp);
        System.out.println(readList);

        BufferedReader br = new BufferedReader(new FileReader("d:/a"));

    }
}
