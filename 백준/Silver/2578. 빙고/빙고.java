import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                findNum(n);
                int rowCnt = row();
                int colCnt = col();
                int diaCnt = dia();

                if (rowCnt + colCnt + diaCnt >= 3) {
                    ans = 5 * i + j + 1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }

    static void findNum(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == n) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }

    static int row() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += arr[i][j];
            }

            if (sum == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    static int col() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += arr[j][i];
            }

            if (sum == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    static int dia() {
        int cnt = 0;

        int sum = 0;
        for (int j = 0; j < 5; j++) {
            sum += arr[j][j];
        }
        if (sum == 0) {
            cnt++;
        }

        sum = 0;
        for (int j = 0; j < 5; j++) {
            sum += arr[j][4 - j];
        }
        if (sum == 0) {
            cnt++;
        }

        return cnt;
    }
}
