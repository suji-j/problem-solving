import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Problem {
        int num, score;

        public Problem(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            list.add(new Problem((i+1), score));
        }

        list.sort((o1, o2) -> {
            return o2.score - o1.score;
        });

        int ans = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ans += list.get(i).score;
            result.add(list.get(i).num);
        }
        Collections.sort(result);

        bw.write(ans + "\n");
        for (int i : result) {
            bw.write(i + " ");
        }
        bw.close();
    }
}
