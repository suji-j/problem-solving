import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int y, x, cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int idx = 1;

        while (n != 0) {
            map = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            dist[0][0] = map[0][0];
            bfs(0, 0, map[0][0]);

            System.out.println("Problem " + idx++ + ": " + dist[n - 1][n - 1]);
            n = Integer.parseInt(br.readLine());
        }
    }

    static void bfs(int y, int x, int cost) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(y, x, cost));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curY = node.y;
            int curX = node.x;
            int curCost = node.cost;

            for (int i = 0; i < 4; i++) {
                int moveY = curY + dy[i];
                int moveX = curX + dx[i];

                if (isVaild(moveY, moveX)) {
                    if (curCost + map[moveY][moveX] < dist[moveY][moveX]) {
                        dist[moveY][moveX] = curCost + map[moveY][moveX];
                        q.add(new Node(moveY, moveX, dist[moveY][moveX]));
                    }
                }
            }
        }
    }

    static boolean isVaild(int moveY, int moveX) {
        return moveY >= 0 && moveX >= 0 && moveY < n && moveX < n;
    }
}
