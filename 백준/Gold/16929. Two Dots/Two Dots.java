import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, startY, startX;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                startY = i;
                startX = j;
                if (dfs(i, j, 0)) {
                    bw.write("Yes");
                    bw.close();
                    return;
                }
            }
        }

        bw.write("No");
        bw.close();
    }

    static boolean dfs(int y, int x, int len) {
        visited[y][x] = true;
        
        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && arr[startY][startX] == arr[moveY][moveX]) {
                if (!visited[moveY][moveX]) {
                    visited[moveY][moveX] = true;
                    if (dfs(moveY, moveX, len + 1)) return true;
                } else {
                    if (len >= 3 && moveY == startY && moveX == startX) return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < n && moveX < m;
    }
}
