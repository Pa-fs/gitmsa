package org.program_test;

public class Spiral {

    // 우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) {

        int n = 4;
        int[][] map = new int[n][n];

        doSpiral(map, n);

        showMap(map, n);
    }

    private static void showMap(int[][] map, int n) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void doSpiral(int[][] map, int n) {
        int y = 0, x = 0;
        int dir = 0;
        int start = 1;
        while (start <= n * n) {
            map[y][x] = start++;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            y = ny;
            x = nx;
        }


    }
}
