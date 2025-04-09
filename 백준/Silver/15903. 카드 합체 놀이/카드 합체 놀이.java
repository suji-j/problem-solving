import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add((long) Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long sum = q.poll() + q.poll();
            q.add(sum);
            q.add(sum);
        }

        int size = q.size();
        long ans = 0;
        for (int i = 0; i < size; i++) {
            ans += q.poll();
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
