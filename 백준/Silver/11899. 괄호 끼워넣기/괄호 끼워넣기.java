import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (s.isEmpty()) {
                if (str.charAt(i) == ')') {
                    result++;
                } else {
                    s.add(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '(') {
                    s.add(str.charAt(i));
                } else {
                    s.pop();
                }
            }
        }

        bw.write(String.valueOf(result + s.size()));
        bw.close();
    }
}
