import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = 1;
        min[0] = 1;

        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                min[i] = min[i - 1] + 1;
                max[i] = 1;
            } else if (arr[i - 1] < arr[i]) {
                max[i] = max[i - 1] + 1;
                min[i] = 1;
            } else {
                max[i] = max[i - 1] + 1;
                min[i] = min[i - 1] + 1;
            }

            ans = Math.max(ans, Math.max(min[i], max[i]));
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
