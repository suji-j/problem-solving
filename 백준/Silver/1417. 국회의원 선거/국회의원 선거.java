import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int cur = pq.poll();
            dasom += 1;
            cur -= 1;
            pq.add(cur);
            ans++;
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
