import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int result = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s2.length() - s1.length(); i++) { // 10 - 3 == 7까지 (0 ~ 6)
            int diff = 0;
            for (int j = i; j < i + s1.length(); j++) {
                sb.append(s2.charAt(j));
            }

            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) != sb.charAt(j)) {
                    diff++;
                }
            }

            if (result > diff) result = diff;
            sb = new StringBuilder();
        }

        System.out.println(result);
    }
}