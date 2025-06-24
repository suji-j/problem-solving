import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int preSum = sum[n] - sum[i + 1];
            ans += (long) preSum * arr[i];
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
