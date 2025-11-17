import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            String str = br.readLine();
            boolean flag = true;

            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("#" + tc + " 1\n");
            } else {
                bw.write("#" + tc + " 0\n");
            }
        }
        bw.close();
    }
}
