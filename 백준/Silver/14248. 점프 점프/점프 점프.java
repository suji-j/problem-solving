import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        dfs(s);

        int ans = 0;
        for (boolean b : visited) {
            if (b) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < 2; i++) {
            int moveV = v + (dx[i] * arr[v]);
            if (isValid(moveV) && !visited[moveV]) {
                dfs(moveV);
            }
        }
    }

    static boolean isValid(int moveV) {
        return moveV > 0 && moveV <= n;
    }
}
