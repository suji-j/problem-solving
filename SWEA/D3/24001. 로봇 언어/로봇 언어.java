import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            String str = br.readLine();
            char[] chArr = new char[str.length()];
            int sum = 0, cnt = 0, max = 0;

            for (int i = 0; i < str.length(); i++) {
                chArr[i] = str.charAt(i);
                if (chArr[i] == 'L') {
                    sum--;
                } else if (chArr[i] == 'R') {
                    sum++;
                } else {
                    cnt++;
                }
                max = Math.max(max, Math.max(Math.abs(sum - cnt), Math.abs(sum + cnt)));
            }
            bw.write(max + "\n");
        }
        bw.close();
    }
}
