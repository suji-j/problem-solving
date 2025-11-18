import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];

            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < n; y++) {
                for (int x = 1; x < n; x++) {
                    map[y][x] = map[y][x - 1] + map[y][x];
                }
            }

            for (int x = 0; x < n; x++) {
                for (int y = 1; y < n; y++) {
                    map[y][x] = map[y - 1][x] + map[y][x];
                }
            }

            int max = 0;
            for (int i = m - 1; i < n; i++) {
                for (int j = m - 1; j < n; j++) {
                    if (i == m - 1 && j == m - 1) {
                        max = Math.max(max, map[i][j]);
                    } else if (i == m - 1 && j != m - 1) {
                        max = Math.max(max, map[i][j] - map[i][j - m]);
                    } else if (i != m - 1 && j == m - 1) {
                        max = Math.max(max, map[i][j] - map[i - m][j]);
                    } else {
                        max = Math.max(max, map[i][j] - map[i - m][j] - map[i][j - m] + map[i - m][j - m]);
                    }
                }
            }

            bw.write("#" + tc + " " + max + "\n");
        }
        bw.close();
    }
}
