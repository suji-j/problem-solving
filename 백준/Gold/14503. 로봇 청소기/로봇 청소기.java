import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0,};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            if (arr[r][c] == 0) {
                arr[r][c] = 2;
                ans++;
            }

            if (isClean(r, c)) {
                int moveR = r + dy[d] * -1;
                int moveC = c + dx[d] * -1;
                if (moveR >= 0 && moveC >= 0 && moveR < n && moveC < m) {
                    if (arr[moveR][moveC] == 1) {
                        break;
                    } else {
                        r = moveR;
                        c = moveC;
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    d -= 1;
                    if (d < 0) d += 4;

                    if (arr[r + dy[d]][c + dx[d]] == 0) {
                        r = r + dy[d];
                        c = c + dx[d];
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }

    static boolean isClean(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int moveR = r + dy[i];
            int moveC = c + dx[i];

            if (moveR >= 0 && moveC >= 0 && moveR < n && moveC < m) {
                if (arr[moveR][moveC] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
