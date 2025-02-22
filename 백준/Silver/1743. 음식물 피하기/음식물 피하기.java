import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int y, x, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[y + 1][x + 1];
        visited = new boolean[y + 1][x + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        int max = 0;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (map[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (isVaild(moveY, moveX) && !visited[moveY][moveX] && map[moveY][moveX] == 1) {
                cnt++;
                dfs(moveY, moveX);
            }
        }
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY > 0 && moveX > 0 && moveY <= y && moveX <= x;
    }
}
