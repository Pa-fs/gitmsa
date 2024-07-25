package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex06 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/kty";
        try {
            // DB 연결 유지 클래스
            Connection connection = DriverManager.getConnection(url, "root", "1234");
            System.out.println("DB connection 성공");

            // SQL 구문 담는 객체
            PreparedStatement pstmt =
                    connection.prepareStatement("INSERT INTO student values ('김철수', '100', '100', '100')");

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("DB connection 실패");
            e.printStackTrace();
        }
    }
}
