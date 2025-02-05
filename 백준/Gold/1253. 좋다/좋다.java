import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < arr[i]) {
                    left++;
                } else if (sum > arr[i]) {
                    right--;
                } else {
                    if (left != i && right != i) {
                        result++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
