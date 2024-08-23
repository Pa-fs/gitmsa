package ex_240821;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRepository {

    public List<Member> select() {

        List<Member> list = new ArrayList<>();
        Connection conn = null; // DB연결해제
        PreparedStatement pstmt = null; // SQL 객체
        ResultSet rs = null; // 연결되는 값 담는 객체

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/kty", "root", "1234");
            pstmt = conn.prepareStatement("select * from member");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Member member = new Member();
                member.setIdx(rs.getInt("idx"));
                member.setAge(rs.getInt("age"));
                member.setEmail(rs.getString("email"));
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));

                list.add(member);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }

        return new ArrayList<>();
    }
}
