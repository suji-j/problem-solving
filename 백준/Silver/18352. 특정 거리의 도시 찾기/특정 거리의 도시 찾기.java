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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, 1));
        }

        dijkstra(x);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                bw.write(i + "\n");
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt == 0 ? -1 : ""));
        bw.close();
    }

    static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.vertex;
            int curCost = cur.cost;

            if (dist[curNode] < curCost) continue;

            for (Node next : list.get(curNode)) {
                int nextCost = curCost + next.cost;

                if (nextCost < dist[next.vertex]) {
                    dist[next.vertex] = nextCost;
                    pq.add(new Node(next.vertex, nextCost));
                }
            }
        }
    }
}
