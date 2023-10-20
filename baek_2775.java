import java.io.*;
import java.util.StringTokenizer;

public class baek_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[15][15];

        for (int i = 0; i < arr.length; i++) {
            arr[0][i] = i;
            arr[i][0] = 0;
            arr[i][1] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 2; j < arr.length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[k][n]);
        }
    }
}
