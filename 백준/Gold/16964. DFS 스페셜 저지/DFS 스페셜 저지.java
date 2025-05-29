import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    static int[] answer;
    static int idx = 1;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        answer = new int[n];

        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        bw.write(String.valueOf(result));
        bw.close();
    }

    static void dfs(int v) {
        visited[v] = true;
        HashSet<Integer> set = new HashSet<>();

        for (int i : list[v]) {
            if (!visited[i]) {
                set.add(i);
            }
        }

        if (set.isEmpty()) {
            return;
        }

        if (set.contains(answer[idx])) {
            dfs(answer[idx++]);
        } else {
            result = 0;
        }
    }
}
