import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        prime = new boolean[1000000];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        int max = 0;
        for (int i = 0; i < t; i++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());
            
            if (max < num) {
                max = num;
                isPrime(num);
            }

            for (int j = 2; j <= num / 2; j++) {
                if (prime[j] && prime[num - j]) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }

    static void isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
