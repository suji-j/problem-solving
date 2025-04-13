import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == -1 && end == -1) {
                break;
            }

            dist[start][end] = 1;
            dist[end][start] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        Map<Integer, Integer> result = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dist[i][j]);
            }
            result.put(i, max);
            min = Math.min(min, max);
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer key : result.keySet()) {
            if (result.get(key) == min) {
                cnt++;
                list.add(key);
            }
        }

        bw.write(min + " " + cnt + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }
        bw.close();
    }
}
