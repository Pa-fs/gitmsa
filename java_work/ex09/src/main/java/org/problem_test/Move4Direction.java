package org.problem_test;

public class Move4Direction {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) {
        int n = 4;
        int[][] answer = new int[n][n];
        moveMapRecursive(answer, 0, 0, 1, n);
//        moveMap(answer, 0, 0, 1, n);
        showMap(answer, n);
    }

    private static void moveMap(int[][] answer, int y, int x, int num, int n) {
        int dir = 0;
        while (num <= n * n) {
            // 먼저 저장
            answer[y][x] = num++;
            // 다음 갈 곳 좌표 설정
            int yy = y + dy[dir];
            int xx = x + dx[dir];
            // 좌표 검증
            if(yy < 0 || yy >= n || xx < 0 || xx >= n || answer[yy][xx] != 0) {
                // 안 되면 방향을 바꾸어 한 번 다시 설정한 후
                dir = (dir + 1) % 4;
                yy = y + dy[dir];
                xx = x + dx[dir];
            }
            // 위로 이동
            y = yy;
            x = xx;
        }
    }

    // 우 하 좌 상
    private static void moveMapRecursive(int[][] answer, int y, int x, int num, int n) {
        if(n <= 0) {
            return;
        }

        // 먼저 저장
        answer[y][x] = num;
        // right, down, left 1 ~ (n-1)
        // up 1 ~ (n - 2)
        // right
        for (int i = 1; i < n; i++) answer[y][++x] = ++num;
        // down
        for (int i = 1; i < n; i++) answer[++y][x] = ++num;
        // left
        for (int i = 1; i < n; i++) answer[y][--x] = ++num;
        // up
        for (int i = 1; i < n - 1; i++) answer[--y][x] = ++num;
        moveMapRecursive(answer, y, x + 1, num + 1, n - 2);
    }

    private static void showMap(int[][] answer, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
