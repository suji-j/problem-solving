import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] lotto;
    static int n;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            lotto = new int[n];
            result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(lotto);

            back(0, 0);
            System.out.println();
        }
    }

    static void back(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;

        }

        for (int i = start; i < n; i++) {
            result.add(lotto[i]);
            back(i + 1, depth + 1);
            result.remove(result.size() - 1);
        }
    }
}
