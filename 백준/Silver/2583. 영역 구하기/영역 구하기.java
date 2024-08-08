import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int m, n;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int space = 0;
        List<Integer> list = new ArrayList<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && map[y][x] == 0) {
                    list.add(dfs(y, x));
                    cnt = 1;
                    space++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(space);

        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static int dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isVaild(ny, nx) && !visited[ny][nx] && map[ny][nx] == 0) {
                cnt++;
                dfs(ny, nx);
            }
        }

        return cnt;
    }

    public static boolean isVaild(int y, int x) {
        return 0 <= x && 0 <= y && y < m && x < n;
    }
}
