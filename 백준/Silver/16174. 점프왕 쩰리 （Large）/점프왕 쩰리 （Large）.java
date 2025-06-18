import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean flag = false;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        bw.write(flag ? "HaruHaru" : "Hing");
        bw.close();
    }

    static void dfs(int y, int x) {
        if (arr[y][x] == -1 || flag) {
            flag = true;
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int moveY = y + (dy[i] * arr[y][x]);
            int moveX = x + (dx[i] * arr[y][x]);

            if (isValid(moveY, moveX) && !visited[moveY][moveX]) {
                dfs(moveY, moveX);
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }
}
