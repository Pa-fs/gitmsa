package ex_240903.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    public List<Member> select() {
        List<Member> list = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234")) { // DB 연결
             PreparedStatement pstmt = conn.prepareStatement("select * from member");
            ResultSet rs = pstmt.executeQuery(); // sql 구문 실행

            while (rs.next()) {
                Member member = new Member(
                        rs.getInt("idx"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getObject("regdate", LocalDateTime.class),
                        rs.getObject("mydate", LocalDateTime.class)
                );
                list.add(member);
            }

            list.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert() {
        LocalDateTime mydate = LocalDateTime.now();

        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/kty", "root", "1234")) {
            PreparedStatement pstmt
                    = conn.prepareStatement("""
                        INSERT INTO member 
                            (name, age, email, password, regdate, mydate)
                        values
                            (?,?,?,?,?,?)
                    """);
            pstmt.setString(1, "홍길동");
            pstmt.setInt(2, 10);
            pstmt.setString(3, "aaa@naver.com");
            pstmt.setString(4, "password");
            pstmt.setObject(5, mydate);
            pstmt.setObject(6, mydate);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 사용자 존재 유무 확인
    public Member findByIdx(int idx) {
        try (Connection conn =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3307/kty", "root", "1234")) {
            PreparedStatement pstmt = conn.prepareStatement("select * from member where idx = ?");
            pstmt.setInt(1, idx);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // 사용자 있음
                return Member.builder()
                        .idx(rs.getInt("idx"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .build();
            } else {
                // 사용자 없음
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
