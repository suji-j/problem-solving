import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    static List<Node>[] list;
    static boolean[] visited;
    static int max = 0, farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[v1].add(new Node(v2, w));
            list[v2].add(new Node(v1, w));
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(farNode, 0);

        bw.write(String.valueOf(max));
        bw.close();
    }

    static void dfs(int v, int cost) {
        visited[v] = true;

        if (cost > max) {
            max = cost;
            farNode = v;
        }

        for (Node cur : list[v]) {
            if (!visited[cur.vertex]) {
                dfs(cur.vertex, cost + cur.cost);
            }
        }
    }
}
