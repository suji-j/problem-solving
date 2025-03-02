import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int m, n;
    static int[][] map, dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int y = 1; y <= n; y++) {
            String[] input = br.readLine().split("");
            int idx = 0;
            for (int x = 1; x <= m; x++) {
                map[y][x] = Integer.parseInt(input[idx++]);
            }
        }

        bfs(1, 1);
        System.out.println(dist[n][m]);
    }

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        dist[1][1] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = cur.y + dy[i];
                int moveX = cur.x + dx[i];

                if (isVaild(moveY, moveX)) {
                    int nextCost = dist[cur.y][cur.x] + map[moveY][moveX];

                    if (nextCost < dist[moveY][moveX]) {
                        dist[moveY][moveX] = nextCost;
                        q.add(new Node(moveY, moveX));
                    }
                }
            }
        }
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY > 0 && moveX > 0 && moveY <= n && moveX <= m;
    }
}
