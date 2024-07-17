package ex09;

public class DFS {

    static char[][] mat = {
            {'1','-','1','1'},
            {'1','-','1','1'},
            {'1','-','-','1'},
            {'1','-','-','-'}
    };

    static int[][] visited = new int[4][4];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    /*
    1-11
    1-11
    1---
     */
    public static void main(String[] args) {
        visited[0][1] = 1;
        dfs(mat, 0, 1);


        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(char[][] mat, int x, int y) {
        System.out.println(x + " " + y);
        if(x == 3 && y == 3) {
            System.out.println("발견");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if(xx < 0 || yy < 0 || xx > 3 || yy > 3
                    || visited[xx][yy] == 1
                    || mat[xx][yy] == '1') continue;
            visited[x][y] = 1;
            dfs(mat, xx, yy);
            visited[x][y] = 0;
        }
    }
}
