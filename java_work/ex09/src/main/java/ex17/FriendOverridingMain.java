package ex17;

import ex17.friend.ComFriend;
import ex17.friend.Friend;
import ex17.friend.UniFriend;

import java.util.Arrays;

public class FriendOverridingMain {

    public static void main(String[] args) {
        int cnt = 0;
        Friend[] friends = new Friend[10];

        friends[cnt++] = new UniFriend("홍길동", "010-1234-1234", "컴퓨터");
        friends[cnt++] = new ComFriend("회사친구", "전화번호", "개발팀");

        System.out.println(Arrays.toString(friends));

        for (int i = 0; i < cnt; i++) {
            friends[i].showInfo();
            System.out.println();
        }
    }
}
