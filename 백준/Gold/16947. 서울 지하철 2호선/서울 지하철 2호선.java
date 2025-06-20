import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean cycle = false;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> cycleV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            cycleV = new ArrayList<>();
            dfs(i, 0, i);

            if (cycle) {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (cycleV.contains(i)) {
                bw.write("0 ");
            } else {
                bw.write(bfs(i) + " ");
            }
        }
        bw.close();
    }

    static int bfs(int v) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{v, 0});
        boolean[] visited = new boolean[n + 1];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            if (cycleV.contains(node)) {
                return dist;
            }

            for (int next : list.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }
        return -1;
    }

    static void dfs(int start, int prev, int cur) {
        if (cycle) return;
        visited[cur] = true;
        cycleV.add(cur);

        for (int next : list.get(cur)) {
            if (prev == next) continue;
            if (start == next) {
                if (cycleV.size() > 2) {
                    cycle = true;
                    return;
                }
            }
            if (!visited[next]) {
                dfs(start, cur, next);
                if (cycle) return;
            }
        }

        cycleV.remove(cycleV.size() - 1);
    }
}
