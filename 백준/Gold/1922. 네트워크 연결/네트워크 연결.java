import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Prim implements Comparable<Prim> {
    int vertex, weight;

    public Prim(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Prim o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static List<List<Prim>> graph = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Prim(v, w));
            graph.get(v).add(new Prim(u, w));
        }

        System.out.println(prim(1, n));
    }

    static int prim(int start, int N) {
        PriorityQueue<Prim> pq = new PriorityQueue<>();
        pq.add(new Prim(start, 0));
        int mstWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < N) {
            Prim node = pq.poll();
            if (visit[node.vertex]) continue;

            visit[node.vertex] = true;
            mstWeight += node.weight;
            cnt++;

            for (Prim next : graph.get(node.vertex)) {
                if (!visit[next.vertex]) pq.add(next);
            }
        }

        return mstWeight;
    }
}