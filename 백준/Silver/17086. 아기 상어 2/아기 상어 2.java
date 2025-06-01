import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static List<Node> shark = new ArrayList<>();
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    shark.add(new Node(i, j));
                }
            }
        }

        for (Node cur : shark) {
            visited = new boolean[n][m];
            bfs(cur.y, cur.x);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dist[i][j]);
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        dist[y][x] = 0;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int moveY = cur.y + dy[i];
                int moveX = cur.x + dx[i];

                if (isValid(moveY, moveX) && !visited[moveY][moveX] && arr[moveY][moveX] == 0) {
                    dist[moveY][moveX] = Math.min(dist[moveY][moveX], dist[cur.y][cur.x] + 1);
                    q.add(new Node(moveY, moveX));
                    visited[moveY][moveX] = true;
                }
            }
        }
    }

    static boolean isValid(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < n && moveX < m;
    }
}
