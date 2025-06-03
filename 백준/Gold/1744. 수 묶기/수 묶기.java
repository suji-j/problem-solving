import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                if (i > 0 && arr[i - 1] > 0 && arr[i] != 1 && arr[i - 1] != 1) {
                    list.add(arr[i] * arr[i - 1]);
                    i--;
                } else {
                    list.add(arr[i]);
                }
            } else if (arr[i] == 0) {
                if (i % 2 == 0) {
                    list.add(arr[i]);
                } else {
                    list.add(arr[i] * arr[i - 1]);
                    i--;
                }
            } else if (arr[i] < 0) {
                if (i % 2 == 0) {
                    list.add(arr[i]);
                } else {
                    list.add(arr[i] * arr[i - 1]);
                    i--;
                }
            }
        }

        int ans = 0;
        for (int i : list) {
            ans += i;
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
