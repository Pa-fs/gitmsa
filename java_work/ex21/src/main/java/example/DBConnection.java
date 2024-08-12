package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    public static void main(String[] args) {

        /*
            1. mysql 드라이버
            build.gradle dependency
            2. Connection
            3. Statement
         */
        try {
            // jar 파일 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DB 연결
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/madangdb", "root", "1234");
            // sql 구문 만들기
            PreparedStatement pstmt = conn.prepareStatement("select * from book");
            // sql 구문 실행
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}
