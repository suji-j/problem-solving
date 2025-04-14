import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sub = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sub[len - 1] < arr[i]) {
                sub[len++] = arr[i];
            } else {
                int left = 0, right = len - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (sub[mid] >= arr[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                sub[left] = arr[i];
            }
        }

        bw.write(String.valueOf(len));
        bw.close();
    }
}
