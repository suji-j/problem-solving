import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && map[y][x] == 1) {
                    dfs(y, x);
                    ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] == 1) {
                dfs(moveY, moveX);
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < m && moveX < n;
    }
}
