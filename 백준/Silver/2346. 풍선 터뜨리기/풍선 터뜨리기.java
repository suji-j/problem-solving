import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int key, value;

        public Balloon(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dq.addLast(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        Balloon cur = dq.pollFirst();
        int idx = cur.key, cnt = cur.value;
        sb.append(idx).append(" ");

        while (!dq.isEmpty()) {
            if (cnt > 0) {
                for (int i = 0; i < cnt - 1; i++) {
                    Balloon pass = dq.pollFirst();
                    dq.addLast(pass);
                }
                cur = dq.pollFirst();
                idx = cur.key;
                cnt = cur.value;
                sb.append(idx).append(" ");
            } else {
                for (int i = 0; i < Math.abs(cnt + 1); i++) {
                    Balloon pass = dq.pollLast();
                    dq.addFirst(pass);
                }
                cur = dq.pollLast();
                idx = cur.key;
                cnt = cur.value;
                sb.append(idx).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
