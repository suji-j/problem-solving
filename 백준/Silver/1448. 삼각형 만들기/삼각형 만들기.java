import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int ans = -1;
        for (int i = 0; i < n - 2; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];

            if (a < b + c) {
                ans = a + b + c;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
