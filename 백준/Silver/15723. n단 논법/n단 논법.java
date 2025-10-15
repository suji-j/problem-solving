import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int n2 = st.nextToken().charAt(0) - 'a';

            arr[n1][n2] = 1;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int n2 = st.nextToken().charAt(0) - 'a';

            bw.write(arr[n1][n2] == Integer.MAX_VALUE ? "F\n" : "T\n");
        }
        bw.close();
    }
}
