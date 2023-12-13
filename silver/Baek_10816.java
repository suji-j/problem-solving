package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek_10816 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!answer.containsKey(num)) {
                answer.put(num, 1);
            } else {
                answer.put(num, answer.get(num)+1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (answer.containsKey(num)) {
                sb.append(answer.get(num) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}
