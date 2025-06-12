import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int p = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < p; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            Arrays.fill(arr, Integer.MAX_VALUE);
            int ans = 0;

            for (int i = 0; i < 20; i++) {
                int cur = Integer.parseInt(st.nextToken());
                arr[i] = cur;

                if (i > 0) {
                    for (int j = i; j > 0; j--) {
                        if (arr[j] < arr[j - 1]) {
                            int temp = arr[j - 1];
                            arr[j - 1] = arr[j];
                            arr[j] = temp;
                            ans++;
                        }
                    }
                }
            }
            bw.write(t + " " + ans + "\n");
        }
        bw.close();
    }
}
