package ex_240902;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int idx;
    private String name;
    private int age;
    private String email;
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime myDate;

    @Override
    public String toString() {
        String temp = myDate == null ? "" : DateTimeFormatter.ofPattern("yyyy/MM/dd").format(myDate);
        return "Member{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", myDate=" + temp +
                '}';
    }
}
