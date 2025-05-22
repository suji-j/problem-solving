import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int ans = 0;
            int d = n / 2;
            for (int i = 0; i < n; i++) {
                int[] row = arr[i];
                if (i <= d) {
                    int[] sub = Arrays.copyOfRange(row, d - i, d + i + 1);
                    ans += Arrays.stream(sub).sum();
                } else {
                    int[] sub = Arrays.copyOfRange(row, d - (n - i) + 1, d + (n - i));
                    ans += Arrays.stream(sub).sum();
                }
            }
            bw.write("#" + (tc + 1) + " " + ans + "\n");
        }
        bw.close();
    }
}
