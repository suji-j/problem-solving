import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static int[] num;
    static boolean[] used;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        used = new boolean[n];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
        }

        back(0);
    }

    static void back(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                result.add(num[i]);
                back(depth + 1);

                used[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
