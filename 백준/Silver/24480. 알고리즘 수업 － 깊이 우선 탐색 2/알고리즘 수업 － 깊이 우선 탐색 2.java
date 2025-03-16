import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        order = new int[n + 1];
        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i], Collections.reverseOrder());
        }

        dfs(r);
        for (int i = 1; i < order.length; i++) {
            bw.write(order[i] + "\n");
        }

        bw.close();
    }

    static void dfs(int v) {
        visited[v] = true;
        order[v] = cnt++;

        for (int next : arr[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
