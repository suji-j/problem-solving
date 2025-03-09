import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static List<List<Node>> bus = new ArrayList<>();
    static int[] dist, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus.get(start).add(new Node(arrival, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());

        prev[start] = -1;
        dijkstra(start);

        System.out.println(dist[arrival]);

        List<Integer> path = new ArrayList<>();
        for (int i = arrival; i != -1; i = prev[i]) {
            path.add(i);
        }

        System.out.println(path.size());
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    static void dijkstra(int vertex) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(vertex, 0));
        dist[vertex] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.vertex;
            int c = current.cost;

            if (dist[v] < c) continue;

            for (Node next : bus.get(v)) {
                int nextCost = c + next.cost;

                if (nextCost < dist[next.vertex]) {
                    dist[next.vertex] = nextCost;
                    prev[next.vertex] = v;
                    pq.add(new Node(next.vertex, nextCost));
                }
            }
        }
    }
}
