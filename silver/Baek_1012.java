import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int moveX[] = {0, 0, -1, 1};
    static int moveY[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int cntT = 0; cntT < t; cntT++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로 길이 (열)
            int n = Integer.parseInt(st.nextToken()); // 세로 길이 (행)
            int k = Integer.parseInt(st.nextToken()); // 배추의 개수

            int[][] arr = new int[n][m];
            for (int i = 0; i < k; i++) { // 배추 위치
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); //열
                int y = Integer.parseInt(st.nextToken()); //행
                arr[y][x] = 1;
            }

            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) { //행(세로)
                for (int j = 0; j < m; j++) { //열(가로)
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, visited, arr, n, m);
                        cnt += 1;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int y, int x, boolean[][] visited, int[][] arr, int n, int m) { //y행(세로), x열(가로)
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + moveX[i];
            int nowY = y + moveY[i];

            if (0 <= nowX && nowX < m && 0 <= nowY && nowY < n && !visited[nowY][nowX] && arr[nowY][nowX] == 1) {
                dfs(nowY, nowX, visited, arr, n, m);
            }
        }

    }
}