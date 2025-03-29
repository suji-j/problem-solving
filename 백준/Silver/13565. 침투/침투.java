import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n, m;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
        }

        bw.write(result ? "YES" : "NO");
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        if (y == m - 1) {
            result = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && map[moveY][moveX] == 0 && !visited[moveY][moveX]) {
                dfs(moveY, moveX);
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < m && moveX < n;
    }
}
