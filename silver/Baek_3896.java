package BaekJoon;

import java.io.*;

//3896-소수 사이 수열
public class Baek_3896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[1299710];
        for (int j = 0; j <= 1299709; j++) {
            prime[j] = true;
        }
        prime[0] = prime[1] = false;

        int sqrt = (int) Math.sqrt(1299709);

        for (int j = 2; j <= sqrt; j++) {
            for (int k = 2; k <= 1299709 / j; k++) {
                if (prime[j * k] == false) {
                    continue;
                } else {
                    prime[j * k] = false;
                }
            }
        }

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            int min = 0, max = 0;

            if (prime[num] == true) {
                bw.write("0\n");
            } else {
                for (int j = 1; j <= num; j++) {
                    if (prime[num - j] == true) {
                        min = num - j;
                        break;
                    }
                }
                for (int j = 1; j <= prime.length; j++) {
                    if (prime[num + j] == true) {
                        max = num + j;
                        break;
                    }
                }
                bw.write((max - min) + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
