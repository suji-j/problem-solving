import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        if (n == 1) {
            System.out.println(0);
        } else if (n < 4) {
            System.out.println(1);
        } else {
            System.out.println(makeOne(n));
        }
    }

    static int makeOne(int n) {
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 6 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, Math.min(arr[i / 2], arr[i - 1]) + 1);
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i - 1] + 1);
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i - 1] + 1);
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[n];
    }
}