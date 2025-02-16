import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max, n;
    static int[][] map;
    static List<Integer> height;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        height = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (!height.contains(map[i][j])) {
                    height.add(map[i][j]);
                }
            }
        }
        Collections.sort(height);
        int cnt = 0;
        max = 1;

        for (int h : height) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] <= h) {
                        map[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;

                        if (max < cnt) {
                            max = cnt;
                        }
                    }
                }
            }
            cnt = 0;
            visited = new boolean[n][n];
        }

        System.out.println(max);

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (vaildYX(moveY, moveX) && map[moveY][moveX] != 0 && !visited[moveY][moveX]) {
                dfs(moveY, moveX);
            }
        }
    }

    static boolean vaildYX(int y, int x) {
        return (y >= 0 && x >= 0 && y < n && x < n);
    }
}
