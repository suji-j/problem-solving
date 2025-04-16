import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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

    static List<List<Node>> graph = new LinkedList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= d; i++) {
            graph.add(new LinkedList<>());
        }

        dist = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (end <= d) {
                graph.get(start).add(new Node(end, w));
            }
        }

        for (int i = 0; i < d; i++) {
            dist[i + 1] = Math.min(dist[i + 1], dist[i] + 1);

            for (Node next : graph.get(i)) {
                if (next.vertex <= d) {
                    dist[next.vertex] = Math.min(dist[next.vertex], dist[i] + next.cost);
                }
            }
        }

        bw.write(String.valueOf(dist[d]));
        bw.close();
    }
}
