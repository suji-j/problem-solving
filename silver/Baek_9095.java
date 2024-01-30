import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[11];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 3) {
                dp(n);
                sb.append(arr[n]).append('\n');
            } else if (n == 1) {
                sb.append("1\n");
            } else if (n == 2) {
                sb.append("2\n");
            } else {
                sb.append("4\n");
            }
        }
        System.out.println(sb);
    }

    static int dp(int n) {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        if (arr[n] != 0) {
            return arr[n];
        } else {
            return arr[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
        }
    }
}