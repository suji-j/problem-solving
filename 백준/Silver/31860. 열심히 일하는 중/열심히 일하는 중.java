import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        List<Integer> result = new ArrayList<>();
        int pre = 0, day = 1;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            int ans = (pre / 2) + cur;
            pre = ans;
            cur -= m;

            if (cur > k) {
                pq.add(cur);
            }
            day++;
            result.add(ans);
        }

        bw.write(day - 1 + "\n");
        for (int i : result) {
            bw.write(i + "\n");
        }
        bw.close();
    }
}
