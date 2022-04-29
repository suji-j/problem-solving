package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//1929
public class Baek_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            prime[i] = true;
        }    // == Arrays.fill(prime, true); 정렬이 필요함

        prime[0] = prime[1] = false;

        int sqrt = (int) Math.sqrt(N);

        for (int i = 2; i <= sqrt; i++) {
            for (int j = 2; j <= N / i; j++) {
                if (prime[i * j] == false) {
                    continue;
                } else {
                    prime[i * j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (prime[i] == true) {
                bw.write(i + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
