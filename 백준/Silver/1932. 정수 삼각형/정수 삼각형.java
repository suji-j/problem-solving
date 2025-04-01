import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] cal = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cal[i][j] = cal[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    cal[i][j] = cal[i - 1][j - 1] + arr[i][j];
                } else {
                    cal[i][j] = Math.max(cal[i - 1][j], cal[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        int max = cal[n - 1][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, cal[n - 1][i]);
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}
