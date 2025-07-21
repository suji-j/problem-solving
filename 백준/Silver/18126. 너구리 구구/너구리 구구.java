import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Node(v2, w));
            list.get(v2).add(new Node(v1, w));
        }

        dfs(1, 0);
        bw.write(String.valueOf(max));
        bw.close();
    }

    static void dfs(int v, long cost) {
        visited[v] = true;

        for (Node next : list.get(v)) {
            if (!visited[next.vertex]) {
                max = Math.max(max, cost + next.cost);
                dfs(next.vertex, cost + next.cost);
            }
        }
    }
}
