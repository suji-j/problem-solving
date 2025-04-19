import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static boolean[][] visited;
    static boolean ans = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, map[0][0]);
        bw.write(ans ? "HaruHaru" : "Hing");
        bw.close();
    }

    static void dfs(int y, int x, int cnt) {
        visited[y][x] = true;

        if (cnt == -1) {
            ans = true;
            return;
        }

        for (int j = 0; j < 2; j++) {
            int nextY = y + dy[j] * cnt;
            int nextX = x + dx[j] * cnt;

            if (isValid(nextY, nextX) && !visited[nextY][nextX]) {
                dfs(nextY, nextX, map[nextY][nextX]);
            }
        }
    }

    static boolean isValid(int nextY, int nextX) {
        return nextY >= 0 && nextX >= 0 && nextY < n && nextX < n;
    }
}
