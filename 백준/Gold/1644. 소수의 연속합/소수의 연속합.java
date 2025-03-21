import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;

            for (int j = 2 * i; j <= n; j += i) {
                arr[j] = 0;
            }
        }

        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) prime.add(i);
        }

        int left = 0, right = 0, sum = 0;
        while (right < prime.size() || sum >= n) {
            if (sum < n) {
                sum += prime.get(right++);
            } else if (sum > n) {
                sum -= prime.get(left++);
            }

            if (sum == n) {
                result++;
                sum -= prime.get(left++);
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
