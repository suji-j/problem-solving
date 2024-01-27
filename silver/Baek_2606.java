import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int node, edge;
    static int[][] gragh;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        StringTokenizer st;

        gragh = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 0; i < edge; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gragh[a][b] = gragh[b][a] = 1;
        }

        dfs(1);

        int count = 0;
        for (int i = 2; i < visit.length; i++) {
            if (visit[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int now) {
        visit[now] = true;

        for (int next = 0; next <= node; ++next) {
            if (!visit[next] && gragh[now][next] != 0) {
                dfs(next);
            }
        }
    }
}