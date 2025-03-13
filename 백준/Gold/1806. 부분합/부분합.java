import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right <= n) {
            sum += arr[right++];

            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
        }

        bw.write(String.valueOf(result == Integer.MAX_VALUE ? 0 : result));
        bw.close();
    }
}
