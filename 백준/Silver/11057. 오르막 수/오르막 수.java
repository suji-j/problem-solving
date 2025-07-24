import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
        }

        long sum = 0;
        for (int i : dp[n]) {
            sum += i;
        }
        bw.write(String.valueOf(sum % 10007));
        bw.close();
    }
}
