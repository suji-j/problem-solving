import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            Deque<Character> dq = new ArrayDeque<>();
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                dq.addLast(str.charAt(i));
            }

            int k = Integer.parseInt(br.readLine());
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                sum += Integer.parseInt(st.nextToken()) % str.length();
            }

            if (sum > 0) {
                for (long j = 0; j < sum; j++) {
                    dq.addLast(dq.pollFirst());
                }
            } else if (sum < 0) {
                for (long j = sum; j < 0; j++) {
                    dq.addFirst(dq.pollLast());
                }
            }

            while (!dq.isEmpty()) {
                bw.write(dq.pollFirst());
            }
            bw.write("\n");
        }
        bw.close();
    }
}
