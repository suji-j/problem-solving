import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int searchStart = Integer.parseInt(st.nextToken());
        int searchEnd = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = arr[end][start] = 1;
        }

        dfs(searchStart, searchEnd, 0);
        System.out.println(-1);
    }

    public static void dfs(int start, int end, int cnt) {
        visited[start] = true;

        if (start == end) {
            System.out.println(cnt);
            System.exit(0);
        }

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] || arr[start][i] == 0) {
                continue;
            }

            dfs(i, end, cnt + 1);
        }
    }
}
