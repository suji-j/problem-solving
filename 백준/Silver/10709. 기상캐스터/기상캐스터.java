import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] ans = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(ans[i], -1);
        }

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                if (str.charAt(j) == 'c') {
                    ans[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (ans[i][j] != 0 && ans[i][j - 1] != -1) {
                    ans[i][j] = ans[i][j - 1] + 1;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
