import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        int max = 0, cnt = 0;
        for (int i = 0; i <= n - x; i++) {
            int result = sum[i + x] - sum[i];
            if (max < result) {
                max = result;
                cnt = 1;
            } else if (max == result) {
                cnt++;
            }
        }

        System.out.println(max == 0 ? "SAD" : max);
        System.out.println(max == 0 ? "" : cnt);
    }
}
