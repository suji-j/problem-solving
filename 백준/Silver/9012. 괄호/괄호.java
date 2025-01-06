import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 괄호가 짝이 맞으면 YES, 아니면 NO -> 스택이 비어있으면 YES
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    s.push(str.charAt(j));
                } else {
                    if (s.empty() || s.peek() != '(') {
                        s.push(str.charAt(j));
                    } else {
                        s.pop();
                    }
                }
            }

            if (s.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
