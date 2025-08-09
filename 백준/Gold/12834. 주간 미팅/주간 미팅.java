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

    static List<List<Node>> node = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int v = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= v; i++) {
            node.add(new ArrayList<>());
        }

        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> player = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            player.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            node.get(v1).add(new Node(v2, w));
            node.get(v2).add(new Node(v1, w));
        }

        int ans = 0;
        for (int k : player) {
            dist = new int[v + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(k);

            ans += (dist[a] == Integer.MAX_VALUE ? -1 : dist[a]);
            ans += (dist[b] == Integer.MAX_VALUE ? -1 : dist[b]);
        }

        bw.write(String.valueOf(ans));
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

            if (dist[curV] < curW) {
                continue;
            }

            for (Node next : node.get(curV)) {
                int nextCost = curW + next.cost;

                if (nextCost < dist[next.vertex]) {
                    dist[next.vertex] = nextCost;
                    pq.add(new Node(next.vertex, nextCost));
                }
            }
        }
    }
}
