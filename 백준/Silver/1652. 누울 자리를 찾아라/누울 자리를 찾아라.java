import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int row = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) row++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) row++;
        }

        int col = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) col++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) col++;
        }
        
        bw.write(row + " " + col);
        bw.close();
    }
}