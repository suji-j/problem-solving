import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, result = Integer.MAX_VALUE;
    static int[][] dist;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dist = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        visited[m] = true;
        list.add(dist[m][m]);
        back(m, 1);

        bw.write(String.valueOf(result));
        bw.close();
    }

    static void back(int v, int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i : list) {
                sum += i;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(dist[v][i]);
                visited[i] = true;
                back(i, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
