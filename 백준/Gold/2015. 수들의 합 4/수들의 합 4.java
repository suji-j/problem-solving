import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] num = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num[i];
        }

        Long ans = 0L;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (sum[i] == k) {
                ans++;
            }

            ans += map.getOrDefault(sum[i] - k, 0L);
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
