import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] preSum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            preSum[i] = preSum[i - 1] + arr[i];
        }

        int idx = 0, result = -Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            result = Math.max(result, preSum[i] - preSum[idx++]);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
