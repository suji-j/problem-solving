import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        boolean[] visited = new boolean[n + 1];
        bfs(r, visited);

        int[] ans = new int[n + 1];
        int idx = 1;
        while (!result.isEmpty()) {
            int num = result.poll();
            ans[num] = idx++;
        }

        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + "\n");
        }

        bw.close();
    }

    static void bfs(int v, boolean[] visited) {
        result.add(v);
        visited[v] = true;
        Queue<Integer> pq = new LinkedList<>();
        pq.add(v);

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int next : list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    result.add(next);
                    pq.add(next);
                }
            }
        }
    }
}
