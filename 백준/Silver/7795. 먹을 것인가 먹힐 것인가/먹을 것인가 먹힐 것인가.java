import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            fillArr(a, n);
            st = new StringTokenizer(br.readLine());
            fillArr(b, m);

            Arrays.sort(a);
            Arrays.sort(b);

            int result = 0;
            for (int aIdx = 0; aIdx < a.length; aIdx++) {
                for (int bIdx = 0; bIdx < b.length; bIdx++) {
                    if (a[aIdx] <= b[bIdx]) break;
                    result++;
                }
            }

            bw.write(result + "\n");
        }
        bw.close();
    }

    static void fillArr(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
