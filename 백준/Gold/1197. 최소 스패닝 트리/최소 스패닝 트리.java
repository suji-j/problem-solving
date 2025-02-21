import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int e1 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, e1));
            graph.get(v2).add(new Node(v1, e1));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int mstWeight = 0;
        int edgeCnt = 0;
        while (!pq.isEmpty() && edgeCnt < v) {
            Node node = pq.poll();
            int ver = node.vertex;
            int wei = node.weight;

            if (visited[ver]) continue;

            visited[ver] = true;
            mstWeight += wei;
            edgeCnt++;

            for (Node n : graph.get(ver)) {
                if (!visited[n.vertex]) {
                    pq.add(new Node(n.vertex, n.weight));
                }
            }
        }

        System.out.println(mstWeight);
    }
}
