import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[d];

        for (int i = 1; i <= k / 2; i++) {
            dp[0] = i;
            for (int j = i; j < k; j++) {
                dp[1] = j;

                for (int day = 2; day < d; day++) {
                    dp[day] = dp[day - 1] + dp[day - 2];
                }

                if (dp[d - 1] == k) {
                    bw.write(dp[0] + "\n" + dp[1]);
                    bw.close();
                    return;
                }
            }
        }
    }
}
