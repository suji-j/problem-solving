import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[m + 1][n + 1];

            dp[0][0] = 1;
            dp[1][1] = 1;

            for (int y = 1; y <= m; y++) {
                for (int x = 0; x <= n; x++) {
                    if (x == 0) {
                        dp[y][x] = dp[y - 1][x];
                    } else {
                        dp[y][x] = dp[y - 1][x - 1] + dp[y - 1][x];
                    }
                }
            }

            bw.write(dp[m][n] + "\n");
        }
        bw.close();
    }
}
