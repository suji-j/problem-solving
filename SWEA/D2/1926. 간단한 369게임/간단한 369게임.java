import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9') {
                    sb.append("-");
                }
            }

            if (sb.length() == 0) {
                bw.write(num + " ");
            } else {
                bw.write(sb.toString() + " ");
            }
        }
        bw.close();
    }
}
