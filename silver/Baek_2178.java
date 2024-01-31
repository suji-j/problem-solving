import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    public int x, y;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] dist;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        dist[0][0] = 1;
        bfs(0, 0);
        System.out.println(dist[n - 1][m - 1]);
    }

    static void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        map[y][x] = 0;

        while (!q.isEmpty()) {
            Point temp = q.poll();

            for (int repeat = 0; repeat < 4; repeat++) {
                int Y = temp.y + moveY[repeat];
                int X = temp.x + moveX[repeat];

                if (0 <= Y && 0 <= X && Y < n && X < m && map[Y][X] == 1) {
                    map[Y][X] = 0;
                    q.offer(new Point(Y, X));
                    dist[Y][X] = dist[temp.y][temp.x] + 1;
                }
            }
        }
    }
}