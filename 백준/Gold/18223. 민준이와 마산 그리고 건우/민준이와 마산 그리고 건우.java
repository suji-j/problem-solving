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

    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        dist = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Node(v2, w));
            list.get(v2).add(new Node(v1, w));
        }

        dijkstra(1);
        int distV = dist[v];
        int distP = dist[p];
        dijkstra(p);
        int distPV = dist[v];

        if (distP + distPV == distV) {
            bw.write("SAVE HIM");
        } else {
            bw.write("GOOD BYE");
        }

        bw.close();
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.vertex]) {
                continue;
            }

            for (Node next : list.get(cur.vertex)) {
                int minCost = cur.cost + next.cost;
                if (minCost < dist[next.vertex]) {
                    dist[next.vertex] = minCost;
                    pq.add(new Node(next.vertex, minCost));
                }
            }
        }
    }
}
