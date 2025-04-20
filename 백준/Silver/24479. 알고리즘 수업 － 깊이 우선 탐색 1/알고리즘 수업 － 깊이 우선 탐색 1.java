import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static Map<Integer, Integer> map = new LinkedHashMap<>();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(r);
        for (int key : map.keySet()) {
            bw.write(map.get(key) + "\n");
        }
        bw.close();
    }

    static void dfs(int v) {
        visited[v] = true;
        map.put(v, cnt++);

        for (int next : list[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
