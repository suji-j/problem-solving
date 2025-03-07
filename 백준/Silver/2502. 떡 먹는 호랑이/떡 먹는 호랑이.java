import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int d, k;
    static boolean overK;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[d];

        overK = false;
        boolean flag = false;
        for (int i = 1; i <= 100000; i++) {
            dp[0] = i;
            for (int j = i; j <= 100000; j++) {
                dp[1] = j;
                recursion(2);

                if (overK) {
                    break;
                }

                if (dp[d - 1] == k) {
                    sb.append(dp[0]).append("\n").append(dp[1]);
                    flag = true;
                    break;
                }
            }

            if (flag) break;
            overK = false;
        }

        bw.write(sb.toString());
        bw.close();
    }

    static void recursion(int n) {
        if (n == d) return;

        dp[n] = dp[n - 1] + dp[n - 2];

        if (dp[d - 1] > k) {
            overK = true;
            dp[d - 1] = 0;
            return;
        }

        recursion(n + 1);
    }
}
