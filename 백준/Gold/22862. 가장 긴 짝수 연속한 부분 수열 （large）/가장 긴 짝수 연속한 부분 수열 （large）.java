import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = 1, max = 0, cur = 0;
        while (right <= n) {
            if (arr[right] % 2 == 0) {
                cur++;
            } else {
                if (k > 0) {
                    k--;
                } else {
                    while (arr[left] % 2 == 0) {
                        cur--;
                        left++;
                    }
                    left++;
                }
            }
            max = Math.max(max, cur);
            right++;
        }

        bw.write(max + "");
        bw.close();
    }
}
