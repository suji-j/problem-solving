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
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bus.get(start).add(new Node(end, w));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);
        System.out.println(dist[endCity]);
    }

    static void dijkstra(int k) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(k, 0));
        dist[k] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curV = cur.vertex;
            int curC = cur.cost;

            if (dist[curV] < curC) continue;

            for (Node next : bus.get(curV)) {
                int nextDist = curC + next.cost;

                if (nextDist < dist[next.vertex]) {
                    dist[next.vertex] = nextDist;
                    q.add(new Node(next.vertex, nextDist));
                }
            }
        }
    }
}
