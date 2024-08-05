import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            int cnt = 0;
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(map, visited, i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
    }

    public static void dfs(int[][] map, boolean[][] visited, int yh, int xw) {
        visited[yh][xw] = true;

        for (int i = 0; i < 8; i++) {
            int y = yh + dy[i];
            int x = xw + dx[i];

            if (0 <= y && y < h && 0 <= x && x < w) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    dfs(map, visited, y, x);
                }
            }
        }
    }
}