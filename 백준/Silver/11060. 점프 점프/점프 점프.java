import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static boolean[] visited;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        bfs(1, 0);

        bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));
        bw.flush();
        bw.close();
    }

    static void bfs(int idx, int w) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{idx, w});
        visited[idx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curIdx = cur[0];
            int curWeight = cur[1];

            if (curIdx > n) {
                continue;
            }
            if (curIdx == n) {
                ans = Math.min(ans, curWeight);
            }

            for (int i = 1; i <= map[curIdx]; i++) {
                int nextIdx = curIdx + i;
                if (nextIdx <= n && !visited[nextIdx]) {
                    q.add(new int[]{nextIdx, curWeight + 1});
                    visited[nextIdx] = true;
                }
            }
        }
    }
}
