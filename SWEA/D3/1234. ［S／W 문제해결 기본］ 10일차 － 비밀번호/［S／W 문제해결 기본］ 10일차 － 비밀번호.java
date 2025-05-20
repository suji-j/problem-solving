import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Stack<Integer> pwd = new Stack<>();

            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                if (pwd.isEmpty()) {
                    pwd.add((int) str.charAt(j));
                } else {
                    if (str.charAt(j) == pwd.peek()) {
                        pwd.pop();
                    } else {
                        pwd.add((int) str.charAt(j));
                    }
                }
            }

            bw.write("#" + (i + 1) + " ");
            StringBuilder sb = new StringBuilder();
            while (!pwd.isEmpty()) {
                sb.append(pwd.pop() - '0');
            }
            bw.write(sb.reverse() + "\n");
        }
        bw.close();
    }
}
