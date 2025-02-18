import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[] pw;
    static int l, c;
    static List<Character> result = new ArrayList<>();
    static List<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        pw = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            pw[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(pw);

        back(0, 0);
    }

    static void back(int start, int depth) {
        if (depth == l) {
            int vowelCnt = 0;
            int conCnt = 0;
            for (char c : result) {
                if (vowel.contains(c)) {
                    vowelCnt++;
                } else {
                    conCnt++;
                }
            }

            if (vowelCnt >= 1 && conCnt >= 2) {
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            result.add(pw[i]);
            back(i + 1, depth + 1);
            result.remove(result.size() - 1);
        }
    }
}
