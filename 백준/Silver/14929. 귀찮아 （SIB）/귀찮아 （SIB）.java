import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long[] preSum = new long[n + 1];
        long result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            preSum[i + 1] = preSum[i] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            long cal = preSum[n] - preSum[i + 1];
            result += arr[i] * cal;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
