import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] list = new long[n + 1];
        long result = fibo(list, n);

        System.out.println(result);
    }

    public static long fibo(long[] list, int n) {
        list[0] = 0;
        list[1] = 1;

        for (int cnt = 2; cnt <= n; cnt++) {
            list[cnt] = list[cnt - 1] + list[cnt - 2];
        }

        return list[n];
    }
}
