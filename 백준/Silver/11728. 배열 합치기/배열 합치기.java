import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aIdx = 0, bIdx = 0, curA = 0, curB = 0;
        while (true) {
            if (aIdx < n) {
                curA = a[aIdx];
            }
            if (bIdx < m) {
                curB = b[bIdx];
            }

            if (aIdx > n && bIdx < m) {
                bw.write(curB + " ");
                bIdx++;
            } else if (bIdx > m && aIdx < n) {
                bw.write(curA + " ");
                aIdx++;
            } else if (curA < curB) {
                bw.write(curA + " ");
                aIdx++;
            } else if (curA > curB) {
                bw.write(curB + " ");
                bIdx++;
            } else {
                bw.write(curA + " " + curB + " ");
                aIdx++;
                bIdx++;
            }

            if (aIdx > n - 1) {
                aIdx = n + 1;
            }
            if (bIdx > m - 1) {
                bIdx = m + 1;
            }

            if (aIdx > n && bIdx > m) {
                break;
            }
        }

        bw.close();
    }
}
