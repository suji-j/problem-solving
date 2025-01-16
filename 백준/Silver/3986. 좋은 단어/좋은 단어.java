import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int ans = cnt;
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            if (str.length() % 2 != 0) {
                ans--;
                continue;
            }

            Stack<Character> s = new Stack<>();
            s.add(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (!s.empty() && str.charAt(j) == s.peek()) {
                    s.pop();
                } else {
                    s.add(str.charAt(j));
                }
            }
            if (!s.empty()) {
                ans--;
            }
        }
        System.out.println(ans);
    }
}
