import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] fibo = new int[41];

        fibo[0] = 0;
        fibo[1] = 1;

        int T = Integer.parseInt(br.readLine());

        for (int i = 2; i <= 40; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("1 0\n");
                continue;
            }

            sb.append(fibo[N - 1] + " " + fibo[N]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
