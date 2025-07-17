import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (m == 1 && n == 1) {
            bw.write("Yes");
        } else {
            bw.write(dfs(0, 0) ? "Yes" : "No");   
        }
        bw.close();
    }

    static boolean dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isValid(nextY, nextX) && !visited[nextY][nextX] && arr[nextY][nextX] == 1) {
                if (nextY == m - 1 && nextX == n - 1) {
                    return true;
                }

                if (dfs(nextY, nextX)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < m && x < n;
    }
}
