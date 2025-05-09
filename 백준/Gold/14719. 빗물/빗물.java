import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = 0; j < height; j++) {
                arr[j][idx] = 1;
            }
            idx++;
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 1) {
                    list.add(j);
                }
            }

            if (list.size() > 1) {
                for (int k = list.size() - 1; k > 0; k--) {
                    ans += ((list.get(k) - 1) - list.get(k - 1));
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
