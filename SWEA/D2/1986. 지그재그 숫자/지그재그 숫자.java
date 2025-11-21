import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                sum += (i % 2 == 0) ? -i : i;
            }
            bw.write("#" + tc + " " + sum + "\n");
        }
        bw.close();
    }
}
