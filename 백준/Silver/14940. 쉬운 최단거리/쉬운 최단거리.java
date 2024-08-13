import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];

        int startY = 0, startX = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        dis[startY][startX] = 0;
        bfs(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dis[i][j] = -1;
                }
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int y, int x) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int curY = now[0] + dy[i];
                int curX = now[1] + dx[i];

                if (isVaild(curY, curX) && !visited[curY][curX] && map[curY][curX] == 1) {
                    q.offer(new int[]{curY, curX});
                    visited[curY][curX] = true;
                    dis[curY][curX] = dis[now[0]][now[1]] + 1;
                }
            }
        }
    }

    public static boolean isVaild(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
