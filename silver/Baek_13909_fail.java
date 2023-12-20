package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_13909_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        boolean[] window = new boolean[N + 1];
        Arrays.fill(window, false);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if ((i * j) <= N) {
                    if (!window[i * j]) {
                        window[i * j] = true;
                    } else {
                        window[i * j] = false;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (window[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
