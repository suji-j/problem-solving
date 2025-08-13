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

    static int max = 0, farNode = 0;
    static List<List<Node>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int v = Integer.parseInt(br.readLine());

        visited = new boolean[v + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while (end != -1) {
                int w = Integer.parseInt(st.nextToken());
                list.get(start).add(new Node(end, w));
                end = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(farNode, 0);

        bw.write(String.valueOf(max));
        bw.close();
    }

    static void dfs(int v, int w) {
        visited[v] = true;

        if (w > max) {
            max = w;
            farNode = v;
        }

        for (Node next : list.get(v)) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, w + next.cost);
            }
        }
    }
}
