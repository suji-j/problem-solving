import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < n; idx++) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            Stack<Character> right = new Stack<>();
            
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '<') {
                    if (!s.isEmpty()) {
                        right.add(s.pop());
                    }
                } else if (str.charAt(i) == '>') {
                    if (!right.isEmpty()) {
                        s.add(right.pop());
                    }
                } else if (str.charAt(i) == '-') {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                } else {
                    s.add(str.charAt(i));
                }
            }
            while (!right.isEmpty()) {
                s.add(right.pop());
            }

            List<Character> list = new ArrayList<>();
            while (!s.isEmpty()) {
                list.add(s.pop());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                bw.write(list.get(i));
            }
            bw.write("\n");
        }

        bw.close();
    }
}
