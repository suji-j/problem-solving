package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> numberPokemon = new HashMap<>();
        Map<String, Integer> namePokemon = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int cnt = 1; cnt <= N; cnt++) {
            String name = br.readLine();
            numberPokemon.put(cnt, name);
            namePokemon.put(name, cnt);
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (48 < quiz.charAt(0) && quiz.charAt(0) < 58) {
                sb.append(numberPokemon.get(Integer.parseInt(quiz))).append("\n");
            } else {
                sb.append(namePokemon.get(quiz)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
