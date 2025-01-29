import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int a = 0; a < k; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(add(i, j, x, y));
        }
    }

    static int add(int i, int j, int x, int y) {
        int sum = 0;

        for (int a = i; a <= x; a++) {
            for (int b = j; b <= y; b++) {
                sum += arr[a][b];
            }
        }

        return sum;
    }
}
