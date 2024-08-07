import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = charArr[j];
            }
        }

        int redGreen = 0, notRedGreen = 0;
        boolean[][] rgVisited = new boolean[n][n];
        boolean[][] nrgVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!nrgVisited[i][j]) {
                    dfs(i, j, nrgVisited);
                    notRedGreen += 1;
                }

                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rgVisited[i][j]) {
                    dfs(i, j, rgVisited);
                    redGreen += 1;
                }
            }
        }

        System.out.println(notRedGreen + " " + redGreen);
    }

    public static void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            char ch = map[y][x];
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX) && !visited[moveY][moveX]) {
                if (ch == map[moveY][moveX]) {
                    dfs(moveY, moveX, visited);
                }
            }
        }
    }

    public static boolean isVaild(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
