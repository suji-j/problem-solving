import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1018 {
    public static int min = 64;
    public static Boolean chess[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chess = new Boolean[N][M];

        for (int cnt = 0; cnt < N; cnt++) {
            String str = br.readLine();

            for (int cnt2 = 0; cnt2 < M; cnt2++) {
                chess[cnt][cnt2] = str.charAt(cnt2) == 'W';
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean color = chess[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (chess[i][j] != color) {
                    count ++;
                }
                color = !color;
            }
            color = !color;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
