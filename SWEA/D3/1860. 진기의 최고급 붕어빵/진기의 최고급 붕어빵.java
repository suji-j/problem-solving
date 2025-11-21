import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 1;
            boolean isValid = true;
            while (!pq.isEmpty()) {
                int customer = pq.poll();
                int bread = (customer / m) * k;
                int need = cnt++;

                if (bread < need) isValid = false;
                if (!isValid) break;
            }

            bw.write("#" + tc + " ");
            bw.write(isValid ? "Possible\n" : "Impossible\n");
        }
        bw.close();
    }
}
