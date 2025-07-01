import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m, swordDist = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] dist;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist[0][0] = 0;
        bfs(0, 0);
        bw.write(String.valueOf(dist[n - 1][m - 1] <= t ? dist[n - 1][m - 1] : "Fail"));
        bw.close();
    }

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        int swordY = 0, swordX = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (arr[cur.y][cur.x] == 2 && swordDist == Integer.MAX_VALUE) {
                swordDist = dist[cur.y][cur.x];
                swordY = cur.y;
                swordX = cur.x;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if (!isValid(nextY, nextX)) continue;
                if (arr[nextY][nextX] == 1) continue;
                if (visited[nextY][nextX]) continue;

                if (dist[nextY][nextX] > dist[cur.y][cur.x] + 1) {
                    dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
                    q.add(new Node(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }

        if (swordDist != Integer.MAX_VALUE) {
            swordDist = (n - 1 - swordY) + (m - 1 - swordX) + swordDist;
            dist[n - 1][m - 1] = Math.min(swordDist, dist[n - 1][m - 1]);
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}
