package ex_240820;

import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {

        char[][] table1 = {
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
        };

        char[][] table2 = {
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
        };

        char[][] board = new char[51][51];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int cnt1 = Integer.MAX_VALUE, cnt2 = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int tmp1 = checkBoard(board, table1, i, j);
                int tmp2 = checkBoard(board, table2, i, j);
                cnt1 = Math.min(cnt1, tmp1);
                cnt2 = Math.min(cnt2, tmp2);
            }

        }

        System.out.println(cnt1 + " " + cnt2);

        System.out.println(Math.min(cnt1, cnt2));
    }

    private static int checkBoard(char[][] board, char[][] table, int n, int m) {
        int answer = 0;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if(board[i][j] != table[i - n][j - m]) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
