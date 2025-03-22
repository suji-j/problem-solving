import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            if (cur != 0) {
                for (int j = 0; j < cur; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                if (pq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            }
        }

        bw.close();
    }
}
