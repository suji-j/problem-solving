import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        friend = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(friend[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int per1 = Integer.parseInt(st.nextToken());
            int per2 = Integer.parseInt(st.nextToken());

            friend[per1][per2] = 1;
            friend[per2][per1] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (friend[i][k] != Integer.MAX_VALUE && friend[k][j] != Integer.MAX_VALUE) {
                        friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int resultPerson = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += friend[i][j];
            }

            if (min > sum) {
                min = sum;
                resultPerson = i;
            }
        }

        System.out.println(resultPerson);
    }
}
