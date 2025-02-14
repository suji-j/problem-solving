import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> result;
    static List<Integer> guess;
    static String[] num;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        result = new ArrayList<>();
        guess = new ArrayList<>();
        num = new String[9];
        used = new boolean[10];

        for (int i = 1; i < 10; i++) {
            num[i - 1] = String.valueOf(i);
        }

        generateGuess(0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String answer = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            guess.removeIf(gu -> !match(String.valueOf(gu), answer, strike, ball));
        }

        System.out.println(guess.size());
    }

    static boolean match(String gu, String answer, int strike, int ball) {
        int matchStrike = 0, matchBall = 0;
        for (int i = 0; i < 3; i++) {
            if (gu.charAt(i) == answer.charAt(i)) {
                matchStrike++;
            } else if (gu.contains(String.valueOf(answer.charAt(i)))) {
                matchBall++;
            }
        }

        return matchStrike == strike && matchBall == ball;
    }

    static void generateGuess(int depth) {
        if (depth == 3) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
            }
            guess.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                result.add(num[i]);
                generateGuess(depth + 1);

                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
