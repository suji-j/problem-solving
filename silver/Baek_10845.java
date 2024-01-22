import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            } else if (order.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (order.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (order.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (order.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (order.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(last).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}