import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] tile;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tile = new long[n + 1];

        tile[1] = 1;
        if (n == 1) {
            System.out.println(tile[1]);
        } else {
            System.out.println(dp(n) % 10007);
        }
    }

    static long dp(int n) {
        tile[2] = 2;

        if (tile[n] != 0) {
            return tile[n];
        } else {
            return tile[n] = dp(n - 1) + dp(n - 2) % 10007;
        }
    }
}