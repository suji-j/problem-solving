import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int y, x, virus;

        public Node(int y, int x, int virus) {
            this.y = y;
            this.x = x;
            this.virus = virus;
        }

        @Override
        public int compareTo(Node o) {
            return this.virus - o.virus;
        }
    }

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static List<Node> virus = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                if (arr[y][x] != 0) {
                    virus.add(new Node(y, x, arr[y][x]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int ansY = Integer.parseInt(st.nextToken()) - 1;
        int ansX = Integer.parseInt(st.nextToken()) - 1;

        for (int time = 1; time <= s; time++) {
            bfs();
        }

        bw.write(String.valueOf(arr[ansY][ansX]));
        bw.close();
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node cur : virus) {
            pq.add(new Node(cur.y, cur.x, cur.virus));
        }
        virus = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];

                if (isValid(nextY, nextX) && !visited[nextY][nextX] && arr[nextY][nextX] == 0) {
                    arr[nextY][nextX] = cur.virus;
                    virus.add(new Node(nextY, nextX, arr[nextY][nextX]));
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
