import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int human = Integer.parseInt(st.nextToken());
        int connection = Integer.parseInt(st.nextToken());
        int[][] dist = new int[human + 1][human + 1];

        for (int i = 1; i <= human; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < connection; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            dist[v1][v2] = 1;
            dist[v2][v1] = 1;
        }

        for (int k = 1; k <= human; k++) {
            for (int i = 1; i <= human; i++) {
                for (int j = 1; j <= human; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= human; i++) {
            for (int j = 1; j <= human; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] > 6) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        bw.write(flag ? "Big World!" : "Small World!");
        bw.close();
    }
}
