import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = br.readLine();
        Stack<String> ls = new Stack<>();
        Stack<String> rs = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            ls.push(String.valueOf(str.charAt(i)));
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            String addStr = "";
            if (com.equals("P")) {
                addStr = st.nextToken();
            }

            if (com.equals("L") && !ls.empty()) {
                rs.push(ls.pop());
            } else if (com.equals("D") && !rs.empty()) {
                ls.push(rs.pop());
            } else if (com.equals("B") && !ls.empty()) {
                ls.pop();
            } else if (com.equals("P")) {
                ls.push(addStr);
            }
        }

        while (!ls.empty()) {
            rs.push(ls.pop());
        }

        while (!rs.empty()) {
            bw.write(rs.pop());
        }
        bw.close();
    }
}