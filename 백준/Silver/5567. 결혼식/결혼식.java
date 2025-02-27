import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int depth, cnt;
    static List<Integer>[] fri;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[n + 1];
        fri = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            fri[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            fri[a].add(b);
            fri[b].add(a);
        }

        bfs(1);
        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            if (depth == 2) break;

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();

                for (int num : fri[cur]) {
                    if (!visited[num]) {
                        visited[num] = true;
                        q.add(num);
                        cnt++;
                    }
                }
            }
            depth++;
        }
    }
}
