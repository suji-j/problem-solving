import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && dp[i - 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        bw.write(String.valueOf(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]));
        bw.close();
    }
}
