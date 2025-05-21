import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for (int j = 2; j < n - 2; j++) {
                int left = Math.max(arr[j - 1], arr[j - 2]);
                int right = Math.max(arr[j + 1], arr[j + 2]);
                int max = Math.max(left, right);
                if (arr[j] > max) {
                    ans += arr[j] - max;
                }
            }

            bw.write("#" + (i + 1) + " " + ans + "\n");
        }
        bw.close();
    }
}
