import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n - 1));
        }
    }

    static long dp(int n) {
        if (arr[n] != 0) {
            return arr[n];
        } else {
            return arr[n] = dp(n - 2) + dp(n - 3);
        }
    }
}