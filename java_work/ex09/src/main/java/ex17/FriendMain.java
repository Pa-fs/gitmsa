package ex17;

import ex17.friend.ComFriend;
import ex17.friend.UniFriend;

import java.util.Arrays;

public class FriendMain {

    public static void main(String[] args) {
        UniFriend[] uniFriends = new UniFriend[10];
        ComFriend[] comFriends = new ComFriend[10];

        int ucnt = 0;
        int ccnt = 0;

        uniFriends[ucnt++] = new UniFriend("홍길동", "010-1234-5678", "ㅎㅎ");
        System.out.println(Arrays.toString(uniFriends));


        for (int i = 0; i < ucnt; i++) {
            uniFriends[i].showInfo();
        }

        for (int i = 0; i < ccnt; i++) {
            comFriends[i].showInfo();
        }
    }
}
