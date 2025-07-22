import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[r + w][r + w];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        int result = 0, row = c - 1;
        for (int i = r; i < r + w; i++) {
            for (int j = c - 1; j <= row; j++) {
                result += dp[i][j];
            }
            row++;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
