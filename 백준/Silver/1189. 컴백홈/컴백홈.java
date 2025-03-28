import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k, ans;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void dfs(int y, int x, int dist) {
        if (y == 0 && x == c - 1) {
            if (dist == k) {
                ans++;
                return;
            }
        }

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isValid(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] != 'T') {
                visited[moveY][moveX] = true;
                dfs(moveY, moveX, dist + 1);
                visited[moveY][moveX] = false;
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < r && moveX < c;
    }
}
