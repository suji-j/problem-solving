import java.io.*;

public class Solution {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            arr[0][0] = 1;
            visited[0][0] = true;

            dfs(0, arr, visited, 0, 0, n, 1);
            bw.write("#" + tc + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.close();
    }

    static void dfs(int idx, int[][] arr, boolean[][] visited, int y, int x, int n, int cnt) {
        if (cnt == n * n) {
            return;
        }
        int moveY = y + dy[idx];
        int moveX = x + dx[idx];

        if (!isValid(moveY, moveX, n) || visited[moveY][moveX]) {
            idx = (idx + 1) % 4;
        } else {
            arr[moveY][moveX] = arr[y][x] + 1;
            visited[moveY][moveX] = true;
            y = moveY;
            x = moveX;
            cnt++;
        }
        dfs(idx, arr, visited, y, x, n, cnt);
    }

    static boolean isValid(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
