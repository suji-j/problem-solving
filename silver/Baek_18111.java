import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = 0;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        int height = 0;
        int shortest = Integer.MAX_VALUE;

        while (max >= 0) {
            int need_block = 0;
            int time = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    need_block += max - arr[i][j];
                }
            }

            if (need_block > b) {
                max--;
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (max - arr[i][j] > 0) {
                            time += (max - arr[i][j]);
                        } else {
                            time += 2 * (arr[i][j] - max);
                        }
                    }
                }

                if (shortest > time) {
                    shortest = time;
                    height = max;
                }
                max--;
            }
        }

        System.out.println(shortest + " " + height);
    }
}