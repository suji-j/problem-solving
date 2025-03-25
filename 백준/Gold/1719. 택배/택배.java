import java.io.*;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static List<Node>[] map;
    static int[][] result;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[v1].add(new Node(v2, w));
            map[v2].add(new Node(v1, w));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    bw.write("- ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.close();
    }

    static void dijkstra(int v) {
        Queue<Node> q = new PriorityQueue<>();
        dist[v][v] = 0;
        q.add(new Node(v, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (dist[v][cur.vertex] < cur.cost) continue;

            for (Node next : map[cur.vertex]) {
                int nextCost = cur.cost + next.cost;

                if (nextCost < dist[v][next.vertex]) {
                    dist[v][next.vertex] = nextCost;
                    q.add(new Node(next.vertex, nextCost));

                    if (v == cur.vertex) {
                        result[v][next.vertex] = next.vertex;
                    } else {
                        result[v][next.vertex] = result[v][cur.vertex];
                    }
                }
            }
        }
    }
}