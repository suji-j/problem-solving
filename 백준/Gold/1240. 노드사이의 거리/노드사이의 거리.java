import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int n, ansW;
    static boolean[] visited;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(v1).add(new Node(v2, w));
            list.get(v2).add(new Node(v1, w));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            ansW = Integer.MAX_VALUE;

            dfs(v1, v2, 0);

            bw.write(ansW + "\n");
        }
        bw.close();
    }

    static void dfs(int start, int end, int w) {
        visited[start] = true;
        if (start == end) {
            ansW = Math.min(ansW, w);
        }

        for (Node next : list.get(start)) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, end, w + next.weight);
            }
        }
    }
}
