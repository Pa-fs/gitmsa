package ex17.friend;

import lombok.ToString;

@ToString
public class ComFriend extends Friend {
    private String department;

    public ComFriend(String name, String phone, String department) {
        super(name, phone);
        this.department = department;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("부서 = " + department);
    }
}
