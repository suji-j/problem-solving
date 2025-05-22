import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static class Burger implements Comparable<Burger> {
        int score, cal;

        public Burger(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }

        @Override
        public int compareTo(Burger o) {
            if (this.score == o.score) {
                return this.cal - o.cal;
            }
            return o.score - this.score;
        }
    }

    static int n, l, max;
    static List<Burger> burger;
    static List<Burger> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            result = new ArrayList<>();
            burger = new ArrayList<>();
            max = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                burger.add(new Burger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(burger);
            back(0, 0);
            bw.write("#" + (i + 1) + " " + max + "\n");
        }

        bw.close();
    }

    static void back(int start, int calSum) {
        int scoreSum = 0;
        for (Burger bur : result) {
            scoreSum += bur.score;
        }

        if (calSum <= l) {
            max = Math.max(max, scoreSum);
        }

        for (int i = start; i < n; i++) {
            int nextCal = calSum + burger.get(i).cal;
            if (nextCal > l) {
                continue;
            }

            result.add(burger.get(i));
            back(i + 1, nextCal);
            result.remove(result.size() - 1);
        }
    }
}
