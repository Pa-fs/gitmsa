package db_240814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBRepository {

    // 1. insert
    // 2. select
    // 3. update
    // 4. delete

    // insert
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 입력");
        String name = scanner.next();
        System.out.println("나이 입력");
        int age = scanner.nextInt();
        try {
            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            System.out.println("연결 성공");
            // 3. sql 문 작성
            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into member(name, age) values (?, ?)");
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            // 4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        System.out.println("select");
    }
}
