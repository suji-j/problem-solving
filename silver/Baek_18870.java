package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> xy = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            xy.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> copy = new ArrayList<>(xy);
        Collections.sort(copy);

        int rank = 0;
        Map<Integer, Integer> ranked = new HashMap<>();
        for (int sortedNum : copy) {
            if (!ranked.containsKey(sortedNum)) {
                ranked.put(sortedNum, rank);
                rank++;
            }

        }

        for (int value : xy) {
            int ranking = ranked.get(value);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}
