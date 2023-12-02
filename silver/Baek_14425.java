package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Map<String, Integer> S = new HashMap<>();
        for (int i = 0; i < N; i++) {
            S.put(br.readLine(), 0);
        }

        for (int i = 0; i < M; i ++) {
            if (S.get(br.readLine()) != null) {
                count++;
            }
        }

        System.out.println(count);
    }
}
