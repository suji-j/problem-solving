import java.io.*;
import java.util.StringTokenizer;

public class baek_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];
        int sum = 0;
        StringTokenizer st;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    board[j][k] = 1;
                }
            }
        }

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (board[i][j] != 0) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
