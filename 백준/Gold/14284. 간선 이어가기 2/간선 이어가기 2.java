import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
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

    static List<List<Node>> graph;
    static int start, end, ans;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        bw.write(String.valueOf(dist[end]));
        bw.close();
    }

    static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.vertex;
            int curW = cur.cost;

            if (dist[curV] < curW) continue;

            for (Node next : graph.get(curV)) {
                int nextCost = curW + next.cost;

                if (nextCost < dist[next.vertex]) {
                    dist[next.vertex] = nextCost;
                    pq.add(new Node(next.vertex, nextCost));
                }
            }
        }
    }
}
