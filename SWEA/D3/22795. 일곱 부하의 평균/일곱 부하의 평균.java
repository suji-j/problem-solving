import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0, sum = 0;

            for (int j = 0; j < 6; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                sum += num;
            }

            int ans = 0;
            for (int j = max + 1; true; j++) {
                if ((sum + j) % 7 == 0) {
                    ans = j;
                    break;
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();
    }
}
