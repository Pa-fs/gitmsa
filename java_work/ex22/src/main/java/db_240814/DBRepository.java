package db_240814;

import java.sql.*;
import java.util.Scanner;

public class DBRepository {

    /*
        1. Class.forName
        2. Connection DB 연결
        3. PrepareStatement sql 구문 작성
        4. sql 구문 실행
        executeUpdate(); -> insert, update, delete, create, alter 문 실행할 때
        executeQuery(); -> select 문 실행할 때
     */
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

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            System.out.println("연결 성공");
            // 3. sql 문 작성
            pstmt = conn.prepareStatement(
                    "insert into member(name, age) values (?, ?)");
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            // 4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("바꿀 이름 입력");
        String changeName = scanner.next();
        System.out.println("나이 입력");
        int age = scanner.nextInt();
        System.out.println("원래 이름 입력");
        String name = scanner.next();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            System.out.println("연결 성공");
            // 3. sql 문 작성
            pstmt = conn.prepareStatement(
                    "update member set name = ?, age = ? where name = ?");
            pstmt.setString(1, changeName);
            pstmt.setInt(2, age);
            pstmt.setString(3, name);
            // 4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void select() {
        Scanner scanner = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            System.out.println("연결 성공");
            // 3. sql 문 작성
            pstmt = conn.prepareStatement(
                    "select * from member");
            // 4. sql 문 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("""
                        name = %s
                        age = %d
                        """.formatted(rs.getString("name"),
                        rs.getInt("age")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 입력");
        String name = scanner.next();
        System.out.println("나이 입력");
        int age = scanner.nextInt();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            System.out.println("연결 성공");
            // 3. sql 문 작성
            pstmt = conn.prepareStatement(
                    "delete from member where name = ?");
            pstmt.setString(1, name);
            // 4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
